package example;

import java.io.File;

public class LS {

	public void readfile(String directory){
		// TODO Auto-generated method stub
       File file=new File(directory);
       File[] tempList = file.listFiles();
       System.out.println("该目录下对象个数："+tempList.length);
       for (int i = 0; i < tempList.length; i++) {
        if (tempList[i].isFile()) {
         System.out.println("文     件："+tempList[i]);
        }
        if (tempList[i].isDirectory()) {
//         System.out.println("文件夹："+tempList[i]);
         readfile(tempList[i].getName());
        }
	}
	}
	
	public static void main(String[] args){
		
		LS ls=new LS();
		ls.readfile("F:\\");
	}
}
