package com.auv.controller.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		String savePath = this.getServletContext().getRealPath("/upload");
		File file = new File(savePath);
		if(!file.exists() && !file.isDirectory()) {
			System.out.println("鐩綍涓嶅瓨鍦紝鍒涘缓鐩綍upload");
			file.mkdirs();
		}
		//1銆佸垱寤轰竴涓狣iskFileItemFactory宸ュ巶
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//2銆佸垱寤轰竴涓枃浠朵笂浼犺В鏋愬櫒
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		if(!ServletFileUpload.isMultipartContent(request)) {
			return "";
		};
		List<FileItem> items = upload.parseRequest(request);
		for(FileItem item:items) {
			if(item.isFormField()) {
				
			}else {
				String filename = item.getFieldName();
				if(filename==null || filename.trim().equals("")) {
					continue;
				}
				filename = filename.substring(filename.lastIndexOf("\\")+1);
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
				message = "涓婁紶鏂囦欢鎴愬姛";
			}
		}
		model.addAttribute("message",message);
		return "uploadfinish";
	}
}
