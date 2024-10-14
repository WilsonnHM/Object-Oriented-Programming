import java.util.ArrayList;
import java.util.Scanner;


abstract class Asset{
    private String nama="";
    private String kategori="";
    private int kuantitas=0;
    abstract String getNama();
    abstract String getKategori();
    abstract int getKuantitas();
    abstract void setAllData(String nama,String kategori,int kuantitas);
    abstract void setNama(String nama);
    abstract void setKategori(String kategori);
    abstract void setKuantitas(int kuantitas);
}

class Perabotan extends Asset{
    private String nama="";
    private String kategori="";
    private int kuantitas=0;
    public String getNama(){
        return this.nama;
    }
    public String getKategori(){
        return this.kategori;
    }
    public int getKuantitas(){
        return this.kuantitas;
    }
    public void setAllData(String nama,String kategori,int kuantitas){
        this.nama=nama;
        this.kategori=kategori;
        this.kuantitas=kuantitas;
    }
    public void setNama(String nama){
        this.nama=nama;
    }
    public void setKategori(String kategori){
        this.kuantitas=kuantitas;
    }
    public void setKuantitas(int kuantitas){
        this.kuantitas=kuantitas;
    }
}

class Kendaraan extends Asset{
    private String nama="";
    private String kategori="";
    private int kuantitas=0;
    public String getNama(){
        return this.nama;
    }
    public String getKategori(){
        return this.kategori;
    }
    public int getKuantitas(){
        return this.kuantitas;
    }
    public void setAllData(String nama,String kategori,int kuantitas){
        this.nama=nama;
        this.kategori=kategori;
        this.kuantitas=kuantitas;
    }
    public void setNama(String nama){
        this.nama=nama;
    }
    public void setKategori(String kategori){
        this.kuantitas=kuantitas;
    }
    public void setKuantitas(int kuantitas){
        this.kuantitas=kuantitas;
    }
}

class MesindanPeralatan extends Asset{
    private String nama="";
    private String kategori="";
    private int kuantitas=0;
    public String getNama(){
        return this.nama;
    }
    public String getKategori(){
        return this.kategori;
    }
    public int getKuantitas(){
        return this.kuantitas;
    }
    public void setAllData(String nama,String kategori,int kuantitas){
        this.nama=nama;
        this.kategori=kategori;
        this.kuantitas=kuantitas;
    }
   public void setNama(String nama){
        this.nama=nama;
    }
    public void setKategori(String kategori){
        this.kuantitas=kuantitas;
    }
    public void setKuantitas(int kuantitas){
        this.kuantitas=kuantitas;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Asset> assetList = new ArrayList<>();
        int menu=0;
        int resetmenu=0;
        String inputbuffer = "";
        String nama="";
        String kategori="";
        int kuantitas=0;
        int count=0;
        int i=1;
        do {
            do {
                if(count==0){
                    System.out.println("============================================================================");
                    System.out.printf("| %-3s | %-20s | %-20s | %-20s |\n", "NO", "Nama", "Kategori", "Kuantitas");
                    System.out.println("============================================================================");
                    System.out.printf("|                       Data Tidak Tersedia                                |\n");
                    System.out.println("============================================================================");
                    System.out.println("1. Insert,update,delete aset");
                    System.out.println("2. Maintenance aset");
                    System.out.println("3. Cetak Laporan");
                    System.out.println("4. Exit");
                    System.out.print("Menu:");
                    count++;
                }
                else if(count>0){
                    System.out.println("============================================================================");
                    System.out.printf("| %-3s | %-20s | %-20s | %-20s |\n", "NO", "Nama", "Kategori", "Kuantitas");
                    System.out.println("============================================================================");
                    for (Asset asset : assetList) {
                       System.out.printf("| %-3s | %-20s | %-20s | %-20s |\n",i,asset.getNama(),asset.getKategori(),asset.getKuantitas());
                       i++;
                    }
                    System.out.println("============================================================================");
                    System.out.println("1. Insert,update,delete aset");
                    System.out.println("2. Maintenance aset");
                    System.out.println("3. Cetak Laporan");
                    System.out.println("4. Exit");
                    System.out.print("Menu:");
                }
                menu = scanner.nextInt();
            }while (menu < 1 || menu > 4);
            switch (menu) {
                case 1:
                    int innermenu=0;
                    int resetinnermenu=0;
                    inputbuffer= scanner.nextLine();
                    do{
                        do{
                            System.out.println("1. Insert aset");
                            System.out.println("2. Update aset");
                            System.out.println("3. Delete aset");
                            System.out.println("4. Exit");
                            System.out.print("Menu:");
                            innermenu=scanner.nextInt();
                        }while(innermenu <1 || innermenu >4 );
                            switch(innermenu){
                                case 1:
                                    inputbuffer= scanner.nextLine();
                                    //kode untuk insert aset
                                    break;
                                case 2:
                                    inputbuffer= scanner.nextLine();

                                    //kode untuk update aset

                                    break;
                                case 3:
                                    inputbuffer= scanner.nextLine();

                                    //kode untuk delete aset

                                    break;
                                case 4:
                                    System.out.println("Exit");
                                    resetinnermenu=1;
                                    break;
                            }
                    }while(resetinnermenu==0);
                    break;
                case 2:
                    inputbuffer = scanner.nextLine();

                    // kode untuk maintance aset

                    break;
                case 3:
                    inputbuffer = scanner.nextLine();

                    // kode untuk cetak laporan

                    break;
                case 4:
                    System.out.print("Exit");
                    resetmenu = 1;
                    break;
            }
        } while (resetmenu == 0);
    }
}