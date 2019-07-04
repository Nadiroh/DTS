import java.util.Scanner;

public class algo1{
	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	System.out.print("Masukkan Angka : ");
	int angka = sc.nextInt();

	int x = 1;
	int y = x*x;

	while(y!=angka){
		x = x + 1;
		y = x * x;
	}
	System.out.println(""+angka+" akar dari " +x);
	}
}