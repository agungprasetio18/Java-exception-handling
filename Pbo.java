class Pbo {
    public static void main(String[] args) {
        System.out.println("oke");
    }

    // error 
     static void hurufPertamaError() {
        int n = 0;
        n = System.in.read();
        System.out.println("Hasil: " + (char) n);
    }
    // kenapa error? karena tidak berada didalam try and catch
    
    // benar
    static void hurufPertamaBenar() {
        try {
            System.out.print("Input Kata:");
            char n = (char) System.in.read();
            System.out.println("Hasil : " + n);
            // input : agung
            // output : a
        } catch (Exception e) {
            System.out.println("error : " + e.getMessage());
        }
    }


   //error
    static void tigaHurufSalah() {
        byte[] b = new byte[5];
        try { System.in.read(); 
        } catch (java.io.Exception e);
        System.out.println("Hasil: " + (char) b[0] + (char) b[1] + (char) b[2]);
        //setelah catch() seharusnya {}
    }

    //benar
    static void tigaHurufBenar(){
        byte [] b = new byte[5];
        try {
            System.out.print("Input Kata : ");
            System.in.read(b);
            System.out.println("Hasil : " + (char) b[0]+ (char) b[1]+ (char) b[2]);
            //Input  : ngulik
            //Output : ngu (karena mengambil 3 huruf pertama)
        }
        catch (java.io.IOException e){
            System.out.println("error : " + e.getMessage());
        }

    }

    //error
    static void tambahDuaAngkaSalah() {
        byte[] b = new byte[5];
        System.out.println("Input bilangan bulat:");
        try { System.in.read(b);
        } catch (java.io.Exception e);
        int N = Integer.valueOf(b).intValue();
        System.out.println("Hasil: "+(N+2));
    }
    //error 1 : setelah catch() seharusnya {}
    //error 2 : valueOf tidak menerima parameter tipe byte 

    //benar 
    static void tambahDuaAngkaBenar() {
        byte[] b = new byte[5];
        char[] c = new char[5];
        System.out.print("Input angka:");

        try {
            System.in.read(b);
            //lakukan looping untuk untuk mengubah byte ke string
            for (int i = 0; i < b.length; i++) {
                if (Integer.valueOf(b[i]) >= 48 && Integer.valueOf(b[i]) <= 57) {
                    c[i] = (char) b[i];
                }
            }
            //buat object string baru
            String cString = new String(c).trim();
            System.out.println("Hasil: " + (Integer.valueOf(cString) + 2));
        } catch (NumberFormatException e) {
            //ini penangan error untuk user bukan memasukan angka
            System.out.println("Masukan angka");
        } catch (Exception e) {
            System.out.println("error : " + e.getMessage());
        }
    }
    //input : 100
    //output : 102

    //input : ngoding
    //output : Masukan angka

}