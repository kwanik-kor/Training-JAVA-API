package day2.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class FileOrder {
	public static void main(String[] args) {
		UserFile f1 = new UserFile(1, 1, "하하하", new GregorianCalendar(2019, 10, 5).getTime());
		UserFile f2 = new UserFile(2, 2, "다리미", new GregorianCalendar(2019, 8, 7).getTime());
		UserFile f3 = new UserFile(3, 3, "최연영", new GregorianCalendar(2019, 4, 9).getTime());
		ProjectFile f4 = new ProjectFile(1, 12, "라디오", new GregorianCalendar(2019, 2, 6).getTime());
		ProjectFile f5 = new ProjectFile(2, 13, "기모찌", new GregorianCalendar(2019, 3, 8).getTime());
		ProjectFile f6 = new ProjectFile(3, 14, "느금마", new GregorianCalendar(2019, 11, 10).getTime());
		
		ArrayList<UserFile> uflist = new ArrayList<UserFile>();
		uflist.add(f1);
		uflist.add(f2);
		uflist.add(f3);
		
		ArrayList<ProjectFile> pflist = new ArrayList<ProjectFile>();
		pflist.add(f4);
		pflist.add(f5);
		pflist.add(f6);
		
		ArrayList<Files> flist = new ArrayList<Files>();
		flist.add(f1);
		flist.add(f2);
		flist.add(f3);
		flist.add(f4);
		flist.add(f5);
		flist.add(f6);
		for(Files f : flist) {
			System.out.println(f.toString());
		}
		System.out.println("--------------------");
		flist = sortByNameDesc(flist);
		for(Files f : flist) {
			System.out.println(f.toString());
		}
		System.out.println("--------------------");
		flist = sortByFileNoDesc(flist);
		for(Files f : flist) {
			System.out.println(f.toString());
		}
		System.out.println("--------------------");
		flist = sortByDateDesc(flist);
		for(Files f : flist) {
			System.out.println(f.toString());
		}
	}
	
	private static ArrayList<Files> sortByNameDesc(ArrayList<Files> flist){
		Collections.sort(flist, new Comparator<Files>() {
			@Override
			public int compare(Files f1, Files f2) {
				if(f1 instanceof UserFile)
					f1 = (Files)f1;
				else if (f2 instanceof ProjectFile)
					f2 = (Files)f2;
				
				if(f1.getFilename().compareTo(f2.getFilename()) > 0)
					return -1;
				else if(f1.getFilename().compareTo(f2.getFilename()) < 0)
					return 1;
				return 0;
			}
		});
		return flist;
	}
	private static ArrayList<Files> sortByFileNoDesc(ArrayList<Files> flist){
		Collections.sort(flist, new Comparator<Files>() {
			@Override
			public int compare(Files f1, Files f2) {
				if(f1 instanceof UserFile)
					f1 = (Files)f1;
				else if (f2 instanceof ProjectFile)
					f2 = (Files)f2;
				
				if(f1.getFileno() > f2.getFileno())
					return -1;
				else if(f1.getFileno() < f2.getFileno())
					return 1;
				return 0;
			}
		});
		return flist;
	}
	private static ArrayList<Files> sortByDateDesc(ArrayList<Files> flist){
		Collections.sort(flist, new Comparator<Files>() {
			@Override
			public int compare(Files f1, Files f2) {
				if(f1 instanceof UserFile)
					f1 = (Files)f1;
				else if (f2 instanceof ProjectFile)
					f2 = (Files)f2;
				
				if(f1.getFiledate().compareTo(f2.getFiledate()) > 0)
					return -1;
				else if(f1.getFiledate().compareTo(f2.getFiledate()) < 0)
					return 1;
				return 0;
			}
		});
		return flist;
	}
}
