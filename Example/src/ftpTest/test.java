package ftpTest;

import java.io.File;
import java.io.FileOutputStream;


public class test {
	public static void main(String[] args){
		FileOperate fo = null;
		String ftpUrl="ftp://inas:1Na512#$@10.221.18.29:21//home/inas/fast-clt-pro/test/热点导入.xlsx";
		String localUrl="../data/";
		try {
			 File file = new File(localUrl);
			 if (!file .exists()&&!file.isDirectory()) {
				 System.out.println("文件夹不存在，新建。。。");
				 file.mkdirs();
			 }
			 System.out.println(file);
			fo = new FileOperate(ftpUrl);
			
			fo.login();
			for(String s:fo.ls())
			System.out.println(s);
			fo.cd();
			
			for(String s:fo.ls())
				System.out.println(s);
			fo.get(ftpUrl.substring(ftpUrl.lastIndexOf("/")+1), new FileOutputStream(localUrl+ftpUrl.substring(ftpUrl.lastIndexOf("/")+1)));
			File file2 = new File(localUrl+ftpUrl.substring(ftpUrl.lastIndexOf("/")+1));
			System.out.println(file2);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
