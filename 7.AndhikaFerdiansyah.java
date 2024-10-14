import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.LocalDate;


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

class Maintenance {
    private String nama = "";
    private String catatan = "";
    private int harga = 0;
    private LocalDate formattedDate;

    public void setAll(String nama, String catatan, int harga) {
        this.nama = nama;
        this.catatan = catatan;
        this.harga = harga;
    }

    public void setDate(LocalDate tanggal){
        this.formattedDate=tanggal;
    }
    public LocalDate getDate(){
        return formattedDate;
    }

    public String getNama() {
        return this.nama;
    }

    public String getCatatan() {
        return this.catatan;
    }

    public int getHarga() {
        return this.harga;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Asset> assetList = new ArrayList<>();
        ArrayList<Maintenance> assetMaintenance = new ArrayList<>();
        int menu = 0;
        int resetmenu = 0;
        String inputbuffer = "";
        String nama = "";
        String kategori = "";
        String kuantitas = "";
        String namaInput = "";
        String tanggal="";
        int count = 0;
        int i = 1;
        int resetcase = 0;
        int resetcase1 = 0;
        int flag = 0;
        int found = 0;
        boolean isInputValid = false;
        boolean isAssetFound = false;
        String inputNama = "";
        String catatan = "";
        int biaya = 0;
        int count2 = 0;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        do {
            do {
                if (count == 0) {
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
                } else if (count > 0) {
                    System.out.println("============================================================================");
                    System.out.printf("| %-3s | %-20s | %-20s | %-20s |\n", "NO", "Nama", "Kategori", "Kuantitas");
                    System.out.println("============================================================================");
                    i = 1;
                    for (Asset asset : assetList) {
                        System.out.printf("| %-3s | %-20s | %-20s | %-20s |\n", i, asset.getNama(), asset.getKategori(), asset.getKuantitas());
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
            } while (menu < 1 || menu > 4);
            switch (menu) {
                case 1:
                    int innermenu = 0;
                    int resetinnermenu = 0;
                    inputbuffer = scanner.nextLine();
                    do {
                        do {
                            System.out.println("1. Insert aset");
                            System.out.println("2. Update aset");
                            System.out.println("3. Delete aset");
                            System.out.println("4. Exit");
                            System.out.print("Menu:");
                            innermenu = scanner.nextInt();
                        } while (innermenu < 1 || innermenu > 4);
                        switch (innermenu) {
                            case 1:
                                inputbuffer = scanner.nextLine();
                                do {
                                    try {
                                        System.out.printf("Nama aset:");
                                        nama = scanner.nextLine();
                                        if (nama.isEmpty()) {
                                            throw new IllegalArgumentException("Nama Aset tidak boleh kosong");
                                        } else if (nama.matches("^[a-zA-Z\\s]*$")) {
                                            resetcase = 1;
                                        } else if (nama.matches("^[a-zA-Z0-9\\s]*$")) {
                                            throw new IllegalArgumentException("Nama Aset tidak boleh mengandung angka");
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                } while (resetcase == 0);
                                do {
                                    try {
                                        System.out.printf("Nama kategori:");
                                        kategori = scanner.nextLine();
                                        if (kategori.isEmpty()) {
                                            throw new IllegalArgumentException("Nama kategori tidak boleh kosong");
                                        } else if (kategori.equals("Perabotan") || kategori.equals("Kendaraan") || kategori.equals("MesindanPeralatan")) {
                                            resetcase = 0;
                                        } else if (kategori.matches("^[a-zA-Z\\s]*$")) {
                                            throw new IllegalArgumentException("Nama kategori harus Perabotan/Kendaraan/MesindanPeralatan");
                                        } else if (kategori.matches("^[a-zA-Z0-9\\s]*$")) {
                                            throw new IllegalArgumentException("Nama kategori tidak boleh mengandung angka");
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                } while (resetcase == 1);
                                do {
                                    try {
                                        System.out.printf("Jumlah kuantitasnya:");
                                        kuantitas = scanner.nextLine();
                                        if (kuantitas.isEmpty()) {
                                            throw new IllegalArgumentException("Jumlah kuantitas tidak boleh kosong");
                                        } else if (kuantitas.matches("[0-9]*$")) {
                                            resetcase = 1;
                                        } else if (kuantitas.matches("^[a-zA-Z0-9\\s]*$")) {
                                            throw new IllegalArgumentException("Jumlah kuantitas tidak boleh mengandung huruf");
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                } while (resetcase == 0);
                                int kuantitas1 = Integer.parseInt(kuantitas);
                                if (kategori.equals("Perabotan")) {
                                    Perabotan perabotan = new Perabotan();
                                    perabotan.setAllData(nama, kategori, kuantitas1);
                                    assetList.add(perabotan);
                                } else if (kategori.equals("Kendaraan")) {
                                    Kendaraan kendaraan = new Kendaraan();
                                    kendaraan.setAllData(nama, kategori, kuantitas1);
                                    assetList.add(kendaraan);
                                } else if (kategori.equals("MesindanPeralatan")) {
                                    MesindanPeralatan mesindanperalatan = new MesindanPeralatan();
                                    mesindanperalatan.setAllData(nama, kategori, kuantitas1);
                                    assetList.add(mesindanperalatan);
                                }
                                System.out.println("\n--Proses Insert Berhasil--\n");
                                break;
                            case 2:
                                inputbuffer = scanner.nextLine();
                                isAssetFound = false;
                                isInputValid = false;
                                do {
                                    try {
                                        System.out.printf("Nama aset:");
                                        namaInput = scanner.nextLine();
                                        if (namaInput.isEmpty()) {
                                            throw new IllegalArgumentException("Nama Aset tidak boleh kosong");
                                        } else if (namaInput.matches("^[a-zA-Z\\s]*$")) {
                                            isInputValid = true;
                                        } else if (namaInput.matches("^[a-zA-Z0-9\\s]*$")) {
                                            throw new IllegalArgumentException("Nama Aset tidak boleh mengandung angka");
                                        }
                                        for (i = 0; i < assetList.size(); i++) {
                                            if (namaInput.equals(assetList.get(i).getNama())) {
                                                isAssetFound = true;
                                                found = i;
                                            }
                                        }
                                        if (isAssetFound == false) {
                                            System.out.println("Asset tidak ditemukan");
                                        } else {
                                            System.out.println("Aset ditemukan");
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                } while (!isInputValid || !isAssetFound);
                                do {
                                    try {
                                        System.out.printf("Ganti nama aset:");
                                        nama = scanner.nextLine();
                                        if (nama.isEmpty()) {
                                            throw new IllegalArgumentException("Nama Aset tidak boleh kosong");
                                        } else if (nama.matches("^[a-zA-Z\\s]*$")) {
                                            resetcase = 0;
                                        } else if (nama.matches("^[a-zA-Z0-9\\s]*$")) {
                                            throw new IllegalArgumentException("Nama Aset tidak boleh mengandung angka");
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                } while (resetcase == 1);
                                do {
                                    try {
                                        System.out.printf("Ganti Nama kategori:");
                                        kategori = scanner.nextLine();
                                        if (kategori.isEmpty()) {
                                            throw new IllegalArgumentException("Nama kategori tidak boleh kosong");
                                        } else if (kategori.equals("Perabotan") || kategori.equals("Kendaraan") || kategori.equals("MesindanPeralatan")) {
                                            resetcase = 1;
                                        } else if (kategori.matches("^[a-zA-Z\\s]*$")) {
                                            throw new IllegalArgumentException("Nama kategori harus Perabotan/Kendaraan/MesindanPeralatan");
                                        } else if (kategori.matches("^[a-zA-Z0-9\\s]*$")) {
                                            throw new IllegalArgumentException("Nama kategori tidak boleh mengandung angka");
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                } while (resetcase == 0);
                                do {
                                    try {
                                        System.out.printf("Ganti Jumlah kuantitasnya:");
                                        kuantitas = scanner.nextLine();
                                        if (kuantitas.isEmpty()) {
                                            throw new IllegalArgumentException("Jumlah kuantitas tidak boleh kosong");
                                        } else if (kuantitas.matches("[0-9]*$")) {
                                            resetcase = 0;
                                        } else if (kuantitas.matches("^[a-zA-Z0-9\\s]*$")) {
                                            throw new IllegalArgumentException("Jumlah kuantitas tidak boleh mengandung huruf");
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                } while (resetcase == 1);
                                /* System.out.printf("%d",found);*/
                                kuantitas1 = Integer.parseInt(kuantitas);
                                if (kategori.equals("Perabotan")) {
                                    Perabotan perabotan = new Perabotan();
                                    perabotan.setAllData(nama, kategori, kuantitas1);
                                    assetList.set(found, perabotan);
                                } else if (kategori.equals("Kendaraan")) {
                                    Kendaraan kendaraan = new Kendaraan();
                                    kendaraan.setAllData(nama, kategori, kuantitas1);
                                    assetList.set(found, kendaraan);
                                } else if (kategori.equals("MesindanPeralatan")) {
                                    MesindanPeralatan mesindanperalatan = new MesindanPeralatan();
                                    mesindanperalatan.setAllData(nama, kategori, kuantitas1);
                                    assetList.set(found, mesindanperalatan);
                                }
                                break;
                            case 3:
                                inputbuffer = scanner.nextLine();
                                isAssetFound = false;
                                isInputValid = false;
                                do {
                                    try {
                                        System.out.printf("Nama aset:");
                                        namaInput = scanner.nextLine();
                                        if (namaInput.isEmpty()) {
                                            throw new IllegalArgumentException("Nama Aset tidak boleh kosong");
                                        } else if (namaInput.matches("^[a-zA-Z\\s]*$")) {
                                            isInputValid = true;
                                        } else if (namaInput.matches("^[a-zA-Z0-9\\s]*$")) {
                                            throw new IllegalArgumentException("Nama Aset tidak boleh mengandung angka");
                                        }
                                        for (Asset asset : assetList) {
                                            if (namaInput.equals(asset.getNama())) {
                                                isAssetFound = true;
                                                assetList.remove(asset);
                                                Iterator<Maintenance> iterator = assetMaintenance.iterator();
                                                while (iterator.hasNext()) {
                                                    Maintenance maintenance = iterator.next();
                                                    if (maintenance.getNama().equals(asset.getNama())) {
                                                        iterator.remove();
                                                    }
                                                }
                                                System.out.println("Proses delete berhasil");
                                                break;
                                            }
                                        }
                                        if (!isAssetFound) {
                                            System.out.println("Asset tidak ditemukan");
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                } while (!isInputValid || !isAssetFound);
                                break;
                            case 4:
                                System.out.println("Exit");
                                resetinnermenu = 1;
                                break;
                        }
                    } while (resetinnermenu == 0);
                    break;
                case 2:
                    inputbuffer = scanner.nextLine();
                    isAssetFound = false;
                    isInputValid = false;
                    if (count2 == 0) {
                        System.out.println("===================================================================================================");
                        System.out.printf("| %-3s | %-20s | %-20s | %-20s | %-20s |\n", "NO", "Nama", "Catatan", "Harga","Waktu");
                        System.out.println("===================================================================================================");
                        System.out.printf("|                               Data Tidak Tersedia                                               |\n");
                        System.out.println("===================================================================================================");
                        count2++;
                    } else if (count2 > 0) {
                        System.out.println("=====================================================================================================");
                        System.out.printf("| %-3s | %-20s | %-20s | %-20s | %-20s   |\n", "NO", "Nama", "Catatan", "Harga","Waktu");
                        System.out.println("=====================================================================================================");
                        i = 1;
                        for (Maintenance maintenance : assetMaintenance) {
                            LocalDate tanggalprint=maintenance.getDate();
                            System.out.printf("| %-3s | %-20s | %-20s | %-20s | %-20s  |\n", i, maintenance.getNama(), maintenance.getCatatan(), maintenance.getHarga(),tanggalprint.format(dateFormat));
                            i++;
                        }
                        System.out.println("=====================================================================================================");
                    }
                    do {
                        try {
                            System.out.printf("Nama aset:");
                            inputNama = scanner.nextLine();
                            if (inputNama.isEmpty()) {
                                throw new IllegalArgumentException("Nama Aset tidak boleh kosong");
                            } else if (inputNama.matches("^[a-zA-Z\\s]*$")) {
                                isInputValid = true;
                            } else if (inputNama.matches("^[a-zA-Z0-9\\s]*$")) {
                                throw new IllegalArgumentException("Nama Aset tidak boleh mengandung angka");
                            }
                            for (Asset asset : assetList) {
                                if (inputNama.equals(asset.getNama())) {
                                    isAssetFound = true;
                                }
                            }
                            if (isAssetFound == false) {
                                System.out.println("Asset tidak ditemukan");
                            } else {
                                System.out.println("Aset ditemukan");
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } while (!isInputValid || !isAssetFound);
                    System.out.print("Catatan maintance:");
                    catatan = scanner.nextLine();
                    System.out.print("Biaya:");
                    biaya = scanner.nextInt();
                    isInputValid=false;
                    inputbuffer= scanner.nextLine();
                    do {
                        try {
                            System.out.print("Tanggal Mulai Maintenance [DD-MM-YYYY]:");
                            tanggal = scanner.nextLine();
                            LocalDate tanggal1 = LocalDate.parse(tanggal, dateFormat);
                            String formattedDate = tanggal1.format(dateFormat);
                            Maintenance maintenance=new Maintenance();
                            maintenance.setAll(inputNama, catatan, biaya);
                            maintenance.setDate(tanggal1);
                            assetMaintenance.add(maintenance);
                            isInputValid=true;
                        } catch (Exception e) {
                            System.out.println("Format tanggal salah. Format:DD-MM-YYYY");
                        }
                    }while(isInputValid==false);
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


