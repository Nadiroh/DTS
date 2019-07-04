import java.util.Scanner;

public class algo3{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Masukkan Jari-Jari : ");
		double jari = sc.nextDouble();

		double luas, kel ;
		luas = 3.14 * jari * jari;
		kel = 2 * 3.14 * jari ;

		System.out.println("Luas lingkaran dari jari-jari "+jari+" adalah "+luas);
		System.out.println("Keliling lingkaran dari jari-jari "+jari+" adalah "+kel);
		}
}