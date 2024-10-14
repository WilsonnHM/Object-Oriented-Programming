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
        String kuantitas="";
        String namaInput="";
        int count=0;
        int i=1;
        int resetcase=0;
        int resetcase1=0;
        int flag=0;
        int found=0;
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
                                    inputbuffer=scanner.nextLine();
                                    do{
                                       try{
                                       System.out.printf("Nama aset:");
                                       nama=scanner.nextLine();
                                       if(nama.isEmpty()){
                                           throw new IllegalArgumentException("Nama Aset tidak boleh kosong");
                                       }
                                       else if(nama.matches("^[a-zA-Z\\s]*$")){
                                           resetcase=1;
                                       }
                                       else if(nama.matches("^[a-zA-Z0-9\\s]*$")){
                                           throw new IllegalArgumentException("Nama Aset tidak boleh mengandung angka");
                                       }
                                       }catch(Exception e){
                                            System.out.println(e);
                                        }
                                    }while(resetcase==0);
                                    do{
                                        try{
                                            System.out.printf("Nama kategori:");
                                            kategori=scanner.nextLine();
                                            if(kategori.isEmpty()){
                                                throw new IllegalArgumentException("Nama kategori tidak boleh kosong");
                                            }
                                            else if(kategori.equals("Perabotan") || kategori.equals("Kendaraan") || kategori.equals("MesindanPeralatan")){
                                                resetcase=0;
                                            }
                                             else if(kategori.matches("^[a-zA-Z\\s]*$")){
                                                throw new IllegalArgumentException("Nama kategori harus Perabotan/Kendaraan/MesindanPeralatan");
                                            }
                                            else if(kategori.matches("^[a-zA-Z0-9\\s]*$")){
                                                throw new IllegalArgumentException("Nama kategori tidak boleh mengandung angka");
                                            }
                                        }catch(Exception e){
                                            System.out.println(e);
                                        }
                                    }while(resetcase==1);
                                    do{
                                        try{
                                            System.out.printf("Jumlah kuantitasnya:");
                                            kuantitas=scanner.nextLine();
                                            if(kuantitas.isEmpty()){
                                                throw new IllegalArgumentException("Jumlah kuantitas tidak boleh kosong");
                                            }
                                            else if(kuantitas.matches("[0-9]*$")){
                                                resetcase=1;
                                            }
                                            else if(kuantitas.matches("^[a-zA-Z0-9\\s]*$")){
                                                throw new IllegalArgumentException("Jumlah kuantitas tidak boleh mengandung huruf");
                                            }
                                        }catch(Exception e){
                                            System.out.println(e);
                                        }
                                    }while(resetcase==0);
                                    int kuantitas1=Integer.parseInt(kuantitas);
                                    if(kategori.equals("Perabotan")){
                                        Perabotan perabotan=new Perabotan();
                                        perabotan.setAllData(nama,kategori,kuantitas1);
                                        assetList.add(perabotan);
                                    }
                                    else if(kategori.equals("Kendaraan")){
                                        Kendaraan kendaraan=new Kendaraan();
                                        kendaraan.setAllData(nama,kategori,kuantitas1);
                                        assetList.add(kendaraan);
                                    }
                                    else if(kategori.equals("MesindanPeralatan")){
                                        MesindanPeralatan mesindanperalatan=new MesindanPeralatan();
                                        mesindanperalatan.setAllData(nama,kategori,kuantitas1);
                                        assetList.add(mesindanperalatan);
                                    }
                                    System.out.println("\n--Proses Insert Berhasil--\n");
                                    break;
                                case 2:
                                    inputbuffer= scanner.nextLine();
                                    boolean isInputValid=false;
                                    boolean isAssetFound=false;
                                        do{
                                            try{
                                                System.out.printf("Nama aset:");
                                                namaInput=scanner.nextLine();
                                                if(namaInput.isEmpty()){
                                                    throw new IllegalArgumentException("Nama Aset tidak boleh kosong");
                                                }
                                                else if(namaInput.matches("^[a-zA-Z\\s]*$")){
                                                    isInputValid=true;
                                                }
                                                else if(namaInput.matches("^[a-zA-Z0-9\\s]*$")){
                                                    throw new IllegalArgumentException("Nama Aset tidak boleh mengandung angka");
                                                }
                                        for (i=0;i<assetList.size();i++) {
                                            if(namaInput.equals(assetList.get(i).getNama())){
                                                isAssetFound=true;
                                                found=i;
                                            }
                                        }
                                        if(isAssetFound==false){
                                            System.out.println("Asset tidak ditemukan");
                                        }
                                        else{
                                            System.out.println("Aset ditemukan");
                                        }
                                        }catch(Exception e){
                                                System.out.println(e);
                                        }
                                        }while(!isInputValid || !isAssetFound);
                                    do{
                                        try{
                                            System.out.printf("Ganti nama aset:");
                                            nama=scanner.nextLine();
                                            if(nama.isEmpty()){
                                                throw new IllegalArgumentException("Nama Aset tidak boleh kosong");
                                            }
                                            else if(nama.matches("^[a-zA-Z\\s]*$")){
                                                resetcase=0;
                                            }
                                            else if(nama.matches("^[a-zA-Z0-9\\s]*$")){
                                                throw new IllegalArgumentException("Nama Aset tidak boleh mengandung angka");
                                            }
                                        }catch(Exception e){
                                            System.out.println(e);
                                        }
                                    }while(resetcase==1);
                                    do{
                                        try{
                                            System.out.printf("Ganti Nama kategori:");
                                            kategori=scanner.nextLine();
                                            if(kategori.isEmpty()){
                                                throw new IllegalArgumentException("Nama kategori tidak boleh kosong");
                                            }
                                            else if(kategori.equals("Perabotan") || kategori.equals("Kendaraan") || kategori.equals("MesindanPeralatan")){
                                                resetcase=1;
                                            }
                                            else if(kategori.matches("^[a-zA-Z\\s]*$")){
                                                throw new IllegalArgumentException("Nama kategori harus Perabotan/Kendaraan/MesindanPeralatan");
                                            }
                                            else if(kategori.matches("^[a-zA-Z0-9\\s]*$")){
                                                throw new IllegalArgumentException("Nama kategori tidak boleh mengandung angka");
                                            }
                                        }catch(Exception e){
                                            System.out.println(e);
                                        }
                                    }while(resetcase==0);
                                    do{
                                        try{
                                            System.out.printf("Ganti Jumlah kuantitasnya:");
                                            kuantitas=scanner.nextLine();
                                            if(kuantitas.isEmpty()){
                                                throw new IllegalArgumentException("Jumlah kuantitas tidak boleh kosong");
                                            }
                                            else if(kuantitas.matches("[0-9]*$")){
                                                resetcase=0;
                                            }
                                            else if(kuantitas.matches("^[a-zA-Z0-9\\s]*$")){
                                                throw new IllegalArgumentException("Jumlah kuantitas tidak boleh mengandung huruf");
                                            }
                                        }catch(Exception e){
                                            System.out.println(e);
                                        }
                                    }while(resetcase==1);
                                   /* System.out.printf("%d",found);*/
                                    kuantitas1=Integer.parseInt(kuantitas);
                                    if(kategori.equals("Perabotan")){
                                        Perabotan perabotan=new Perabotan();
                                        perabotan.setAllData(nama,kategori,kuantitas1);
                                        assetList.set(found,perabotan);
                                    }
                                    else if(kategori.equals("Kendaraan")){
                                        Kendaraan kendaraan=new Kendaraan();
                                        kendaraan.setAllData(nama,kategori,kuantitas1);
                                        assetList.set(found,kendaraan);
                                    }
                                    else if(kategori.equals("MesindanPeralatan")){
                                        MesindanPeralatan mesindanperalatan=new MesindanPeralatan();
                                        mesindanperalatan.setAllData(nama,kategori,kuantitas1);
                                        assetList.set(found,mesindanperalatan);
                                    }
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