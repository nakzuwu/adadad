import javax.print.attribute.standard.PrinterInfo;
import java.util.Random;
import java.util.Scanner;
//ketika di run loop tidak sempurna
//penambahan beban tidak keluar saat di sout
public class Main {
    int jumLantai = 3;
    static int Jumlahkendaraaan = 150;
    //berat dari daya tahan bangunan
    static int berattotal = 8000000;
    public static String[] blt1 = new String[450000];
    public static String[] blt2 = new String[200000];
    public static String[] blt3 = new String[150000];
    public static String[] L1 = new String[150];
    public static String[] L2 = new String[150];
    public static String[] L3 = new String[150];
    //menghitungg berat yang masuk
    public static void infomobilyangmasuk() {
        int totalsisakendaraan;
        int totall1 = 0;
        for (int i = 0; i < L1.length; i++) {
            if (L1[i] != null) {
                totall1++;
            }
        }
        int totall2 = 0;
        for (int i = 0; i < L2.length; i++) {
            if (L2[i] != null) {
                totall2++;
            }
        }
        int totall3 = 0;
        for (int i = 0; i < L3.length; i++) {
            if (L3[i] != null) {
                totall3++;
            }
        }
        totalsisakendaraan = Jumlahkendaraaan - totall1 - totall2 - totall3;
        System.out.println("Jumlah kendaraan lantai 1 : " + totall1 + " | Jumlah kendaraan lantai 2: " + totall2 + " | Jumlah kendaraan lantai 3: " + totall3);
        System.out.println("Jumlah kendaraan yang masuk : " + Jumlahkendaraaan + "| Sisa kendaraan yang dapat dimuat: " + totalsisakendaraan);
    }
    public static void infoberatyangmasuk() {
        int beratsisa;
        int totalberatl1 = 0;
        for (int i = 0; i < blt1.length; i++) {
            if (blt1[i] != null) {
                totalberatl1++;
            }
        }
        int totalberatl2 = 0;
        for (int i = 0; i < blt2.length; i++) {
            if (blt2[i] != null) {
                totalberatl2++;
            }
        }
        int totalberatl3 = 0;
        for (int i = 0; i < blt3.length; i++) {
            if (blt3[i] != null) {
                totalberatl1++;
            }
        }
        beratsisa = berattotal - totalberatl1 - totalberatl2 - totalberatl3;
        System.out.println("total berat lantai 1 : " + totalberatl1 + " | Total berat lantai 2: " + totalberatl2 + " | total berat lantai 3: " + totalberatl3);
        System.out.println("Jumlah berat kendaraan yang masuk : " + berattotal + "| Sisa berat yang dapat dimuat: " + beratsisa);
    }
    public static void CheckIndexArray(String[] myArray, String kendaraan) {
        int IndexNow = 0;
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] != null) {
                IndexNow = i + 1;
            }
        }
        if (IndexNow < myArray.length) {
            myArray[IndexNow] = kendaraan;
        }
    }
    public static void CheckIArray(String[] Array, String plat) {
        int INow = 0;
        for (int i = 0; i < Array.length; i++) {
            if (Array[i] != null) {
                INow = i + 1;
            }
        }
        if (INow < Array.length) {
            Array[INow] = plat;
        }
    }

    public static void simpankendaraan(int angkaRandom, String kendaraan) {
        switch (angkaRandom) {
            case 1:
                CheckIndexArray(L1, kendaraan);
                System.out.println("kamu parkir dilantai 1");
                infoberatyangmasuk();
                break;
            case 2:
                CheckIndexArray(L2, kendaraan);
                System.out.println("kamu parkir dilantai 2");
                infoberatyangmasuk();
                break;
            case 3:
                CheckIndexArray(L3, kendaraan);
                System.out.println("kamu parkir dilantai 3");
                infoberatyangmasuk();
                break;
        }
    }

    public static void simpanberat(int berat, String kendaraan) {
        switch (berat) {
            case 1:
                CheckIArray(blt1, kendaraan);
                System.out.println("kamu parkir dilantai 1");
                infomobilyangmasuk();
                break;
            case 2:
                CheckIArray(blt2, kendaraan);
                System.out.println("kamu parkir dilantai 2");
                infomobilyangmasuk();
                break;
            case 3:
                CheckIArray(blt3, kendaraan);
                System.out.println("kamu parkir dilantai 3");
                infomobilyangmasuk();
                break;
        }
    }
    public static void inputmobil () {
        Scanner udin = new Scanner(System.in);
        while (true) {
            System.out.print("Masukan plat nomor : ");
            String Plat = udin.nextLine();
            System.out.print("masukan berat kendaraan (dalam ton) : ");
            int beratmobil = udin.nextInt();
            if (Plat.isBlank()){
                System.out.println("Wajib diisi!!");
                inputmobil();
            } else {
                Random hasilRandom = new Random();
                int JenisRandom = hasilRandom.nextInt(3) + 1;
                simpankendaraan(JenisRandom,Plat);
                simpanberat(beratmobil,Plat);
            }
        }
    }
    public static void main (String[]args) {
        inputmobil();
    }
}