package practise.exercise;

public class HomeWork1 {
	
	public HomeWork1(int num1,int num2) {
		if(num1>num2) {
			System.out.println("�ϴ��ֵΪ��"+num1);
		}else if(num1==num2){
			System.out.println("��ֵһ����");
		}else {
			System.out.println("�ϴ��ֵΪ��"+num2);
		}
	}
	public HomeWork1(double num3,double num4,double num5) {
		System.out.println("�˻�Ϊ��"+num3*num4*num5);
		
	}
	public HomeWork1(String str1,String str2) {
		if(str1.equals(str2)) {
			System.out.println("���ַ�����ͬ");
		}else {
			System.out.println("���ַ�����ͬ");
		}
	}
	public static void main(String[] args) {
		HomeWork1 hWork1 = new HomeWork1(23, 15);
		HomeWork1 hWork2 = new HomeWork1(2.23,45.2,12.3);
		HomeWork1 hWork3 = new HomeWork1("��ã�����","Hello��World");
	}
	public static void test() {
		System.out.println("test for difference");
	}
	public static void test1() {
		System.out.println("Test ");
	}
	//����ֻ�ύ�����ļ�
	public static void test2() {
		System.out.println("test for new branch");
	}
	public static void forTest() {
		System.out.println("ttttttttt");
	}
	
	public static void tttttest() {
		System.out.println("qqqqqqq");
	}
	public static void hadoopCaozuo() {
		System.out.println("hadoopCaozuo");
	}
	public static void practiseCaozuo() {
		System.out.println("practiseCaozuo");
	}
	public static void hadoopCaozuo3() {
		System.out.println("hadoopCaozuo3");
	}
	public static void practiseCaozuo2() {
		System.out.println("practiseCaozuo2");
	}
	public static void practiseCaozuo3() {
		System.out.println("practiseCaozuo3");
	}

	public static void hadoopCaozuo4() {
		System.out.println("hadoopCaozuo4");
	}

	public static void practiseCaozuo4() {
		System.out.println("practiseCaozuo4");
	}
	public static void practiseMergeTools() {
		System.out.println("practiseMergeTools");
	}
}
