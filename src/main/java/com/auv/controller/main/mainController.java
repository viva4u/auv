package com.auv.controller.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.auv.service.serviceInterface.userBasicService;


@Controller
public class mainController extends HttpServlet{
	@Autowired
	userBasicService userBasicService;
	@RequestMapping(value="auv/main")
	@ResponseBody
	public Map<String, Object> pageQuery(Integer pageNumber,Integer pageSize) {
//		User user = userBasicService.getUserByIdService(1);
//		System.out.println(request);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", (pageNumber-1)*pageSize);
		params.put("size", pageSize);
		return userBasicService.pageQueryService(params);
	}
	@RequestMapping("select")
	@ResponseBody
    public  Map<String,Object> selectByFy(int pageSize,int pageNumber,String name,Integer age){
        /*鎵�闇�鍙傛暟*/
        Map<String, Object> param=new HashMap<String, Object>();
        int a=(pageNumber-1)*pageSize;
        int b=pageSize;
        param.put("a", a);
        param.put("b", b);
        param.put("name", name);
        param.put("age", age);
        return userBasicService.pageQueryService(param);
    } 
	@RequestMapping("test")
	public String testpagequery() {
//		System.out.println(pageNumber);
		return "pageQuery";
	}
	@RequestMapping("upload")
	public String upLoad() {
		return "upload";
	}
	@RequestMapping("uploadfile")
	public String upLoadFile(HttpServletRequest request,Model model) throws IOException, FileUploadException {
		String message = null;
//		String savePath = "D:/_web/upload";
		String savePath = request.getServletContext().getRealPath("/WEB-INF//upload");
		//System.out.println("savePath:"+savePath);
		File file = new File(savePath);
		if(!file.exists() && !file.isDirectory()) {
			System.out.println("目录不存在，创建目录");
			file.mkdirs();
		}
		//1銆佸垱寤轰竴涓狣iskFileItemFactory宸ュ巶
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//2銆佸垱寤轰竴涓枃浠朵笂浼犺В鏋愬櫒
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		if(!ServletFileUpload.isMultipartContent(request)) {
			return "";
		}
		List<FileItem> items = upload.parseRequest(request);
		for(FileItem item:items) {
			if(item.isFormField()) {
				
			}else {
				String filename = item.getName();
				if(filename==null || filename.trim().equals("")) {
					continue;
				}
				System.out.println("filename:"+filename);
				filename = filename.substring(filename.lastIndexOf("\\")+1);
				System.out.println("filename:"+filename);
				FileOutputStream outputStream = new FileOutputStream(savePath+"\\"+filename);
				InputStream inputStream = item.getInputStream();
				byte buffer[] = new byte[1024];
				int len = 0;
				while((len = inputStream.read(buffer))>0) {
					outputStream.write(buffer,0,len);
				}
				inputStream.close();
				outputStream.close();
				item.delete();
				message = "上传成功";
			}
		}
		model.addAttribute("message",message);
//		attributes.addAttribute("message", message);
//		return "uploadfinish";
		return "redirect:/downloadFiles";
	}
	@RequestMapping("uploadfinished")
	public String uploadfinished(RedirectAttributes attributes) {
//		attributes.addAttribute("message", message);
		return "uploadfinished";
	}
	//不论file为文件还是目录，获取file下面的所有文件
	public void listFile(File file,Map<String, String> map) {
		if(file.isFile()) {
			String fileName = file.getName().substring(file.getName().indexOf("\\")+1);
			System.out.println("key:"+file.getName());
			System.out.println("value:"+fileName);
			map.put(file.getName(), fileName);
		}else {
			File[] files = file.listFiles();
			for(File fileitem : files) {
				listFile(fileitem, map);
			}
		}
	}
	@RequestMapping("downloadFiles")
	public String downloadfiles(HttpServletRequest request,Model model) {
		String savePath = request.getServletContext().getRealPath("/WEB-INF/upload");
		File file = new File(savePath);
		Map<String, String> filesmap = new HashMap<String, String>();
		listFile(file, filesmap);
		model.addAttribute("filesmap", filesmap);
		return "downloadfiles";
	}
	@RequestMapping("download")
	public void download(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
		String filename = request.getParameter("filename");
		String savePath = request.getServletContext().getRealPath("/WEB-INF/upload");
		//需要增加如下语句，防止中文乱码
		filename = new String(filename.getBytes("iso8859-1"),"UTF-8");
		String realname = filename;
		filename = savePath+"\\"+filename;
		File file = new File(filename);
		if(!file.exists()) {
			model.addAttribute("message", "文件已被删除");
			System.out.println("文件已被删除");
		}
		//设置响应头，控制浏览器下载该文件
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
		FileInputStream fileInputStream = new FileInputStream(filename);
		OutputStream outputStream = response.getOutputStream();
		byte buffer[] =new byte[1024];
		int len = 0;
		while((len = fileInputStream.read(buffer))>0) {
			outputStream.write(buffer, 0, len);
		}
		fileInputStream.close();
		outputStream.close();
	}
}
