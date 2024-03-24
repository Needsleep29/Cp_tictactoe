/* Kelompok 6
*Nama: Icha Dwi Yanti (2203125311)
*       Hana Mardhatillah (2203112547)
*       Muhammad Farraz Aqil (2203111632)
*       Muhammad Aqshal Maulana (2203110484)
*       Rahma Juliani (2203113894)
* Kelas: Sistem Informasi A
* Tanggal: 7 oktober 2022
* Deskripsi: Membuat Permainan Tic Tac Toe
*/

import java.util.*;

public class SilangBulatSilang {

    static String[] kotak;
    static String turn;

    static String checkWinner()
    {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = kotak[0] + kotak[1] + kotak[2];
                    break;
                case 1:
                    line = kotak[3] + kotak[4] + kotak[5];
                    break;
                case 2:
                    line = kotak[6] + kotak[7] + kotak[8];
                    break;
                case 3:
                    line = kotak[0] + kotak[3] + kotak[6];
                    break;
                case 4:
                    line = kotak[1] + kotak[4] + kotak[7];
                    break;
                case 5:
                    line = kotak[2] + kotak[5] + kotak[8];
                    break;
                case 6:
                    line = kotak[0] + kotak[4] + kotak[8];
                    break;
                case 7:
                    line = kotak[2] + kotak[4] + kotak[6];
                    break;
            }
            //jika x menang
            if (line.equals("XXX")) {
                return "X";
            }

            // jika o menang
            else if (line.equals("OOO")) {
                return "O";
            }
        }


        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(kotak).contains(String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "seri";
            }
        }

        // Untuk memasukkan X atau O ditempat yang tepat di papan.
        System.out.println(
                turn + "giliran Anda; masukkan nomor papan " + turn + " masukkan:");
        return null;
    }

    // To print out the kotak.
	/* |---|---|---|
	| 1 | 2 | 3 |
	|-----------|
	| 4 | 5 | 6 |
	|-----------|
	| 7 | 8 | 9 |
	|---|---|---|*/

    static void printkotak()
    {


        System.out.println("" + kotak[0] + "|" + kotak[1] + "|" + kotak[2]);
        System.out.println("-----");
        System.out.println("" + kotak[3] + "|" + kotak[4] + "|" + kotak[5]);
        System.out.println("-----");
        System.out.println("" + kotak[6] + "|" + kotak[7] + "|" + kotak[8]);
        System.out.println("--------------------------");
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        kotak = new String[9];
        turn = "X";
        String winner = null;

        for (int a = 0; a < 9; a++) {
            kotak[a] = String.valueOf(a + 1);
        }

        System.out.println("Mari bermain Silang-Bulat-Silang!");
        System.out.println("Anda dapat memilih kotak 1-9 untuk mulai bermain");
        printkotak();

        System.out.print("Pilih kotak kosong (1-9) untuk disilang: ");

        while (winner == null) {
            int numInput;

            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Pilihan tidak valid:  Pilihan diluar angka 1-9.");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Input salah; masukkan kembali nomor:");
                continue;
            }

            // Permainan ini memiliki 2 pemain; X dan O
            // Berikut kode untuk menentukan urutan.
            if (kotak[numInput - 1].equals(String.valueOf(numInput))) {
                kotak[numInput - 1] = turn;

                if (turn.equals("X")) {
                    turn = "O";
                }
                else {
                    turn = "X";
                }

                printkotak();
                winner = checkWinner();
            }
            else if (kotak[numInput - 1] !=" ") {
                System.out.println("Kotak" + kotak[numInput - 1]+ " sudah terisi");
            }
        }

        // Jika tidak ada yang menang atau kalah dari kedua pemain X dan O.
        // Maka inilah logika untuk mencetak "draw".
        if (winner.equalsIgnoreCase("seri")) {
            System.out.println("seri");
        }

        // bagi pemenang menampilkan Selamat!
        else {
            System.out.println("Anda Menang" + winner);
        }
    }
}
