package uet.oop.bomberman;

public class DieuKhien {
    public int[][] a = new int[100][100];
    /*
    a[i][j]=10;      // tang toc do
    a[i][j]=6;   //tuong co the pha huy
    a[i][j]=7;    // tuong co dinh
    a[i][j]= 5; // doi tuong giau sau khi diet het quoai
    a[i][j] = 4; // quai mau do
    a[i][j]= 3;    //con quai mau xanh
    a[i][j] =2;   // bom
    a[i][j]=1;    // tang do dai cua bom
    a[i][j]=0; // co
    a[i][j]=-1 // tang toc do
    * */
//    public DieuKhien() throws FileNotFoundException {
//        loadMap();
//    }
//    public void loadMap() throws FileNotFoundException {
//        FileInputStream fileInputStream = new FileInputStream("bomberman-starter-starter-2/res/levels/Level1.txt");
//        DataInputStream dis = new DataInputStream(fileInputStream);
//        Scanner scanner = new Scanner(fileInputStream);
//        int l = scanner.nextInt();
//        int r = scanner.nextInt();
//        int c = scanner.nextInt();
//        scanner.nextLine();
//        for (int j = 0; j < r; j++) {
//            String line = scanner.nextLine();
//            for (int i = 0; i < line.length(); i++) {
//                Entity object;
//                switch (line.charAt(i)) {
//                    case '#':
//                        a[i][j] = 7;
//                        break;
//                    case '*':
//                        a[i][j] = 6;
//                        break;
//                    case 'x':
//                        a[i][j] =5;
//                        break;
//                    case 'p':
////                        object = new Bomber(i, j, Sprite.player_down.getFxImage());
////                        entities.add(object)
//                        a[i][j] = 0;
//                        break;
//                    case '1':
//                        a[i][j] = 0;
//                        break;
//                    case '2':
//                        a[i][j] = 0;
//                        break;
//                    case 'b':
//                        a[i][j] = 2;
//                        break;
//                    case 'f':
//                        a[i][j] = 1;
//                        break;
//                    case 's':
//                        a[i][j] = -1;
//                        break;
//                    default:
////                        object = new Grass(i, j, Sprite.grass.getFxImage());
////                        stillObjects.add(object);
//                        a[i][j]=0;
//                        break;
//                }
//            }
//        }
//    }
//    public void loadFile() throws FileNotFoundException {
//        PrintWriter printWriter=new PrintWriter("C:\\Users\\leman\\IdeaProjects\\bomberman-starter-starter-2\\Bomberman-LHL\\bomberman-starter-starter-2\\res\\levels\\level1_check.txt");
//        printWriter.println(1+" "+13+" "+31);
//        for (int j = 0; j < 13; j++) {
//            for (int i = 0; i < 31; i++) {
//                if(a[i][j] == 7) printWriter.print("#");
//                if(a[i][j] == 6) printWriter.print("*");
//                if(a[i][j] == 5) printWriter.print("x");
//                if(a[i][j] == 20) printWriter.print("p");
//                if(a[i][j] == 4) printWriter.print("1");
//                if(a[i][j] == 3) printWriter.print("2");
//                if(a[i][j] == 2) printWriter.print("b");
//                if(a[i][j] == 1) printWriter.print("f");
//                if(a[i][j] == -1) printWriter.print("s");
//                if(a[i][j] == 0) printWriter.print(" ");
//            }
//            printWriter.println();
//        }
//        printWriter.close();
//    }
//    public boolean diChuyenSangTrai(int vitribandaux,int vitribandauy,int dodichuyen){
//        if(vitribandaux % Sprite.SCALED_SIZE != 0) return true;
//        else if(vitribandauy % Sprite.SCALED_SIZE == 0){
//            if( a[(vitribandaux / Sprite.SCALED_SIZE) -1][(vitribandauy/Sprite.SCALED_SIZE)] == 0 ){
//                return true;
//            }
//            else return false;
//        }else{
//            if(a[(vitribandaux /Sprite.SCALED_SIZE )-1][(vitribandauy /Sprite.SCALED_SIZE)] ==0 && a[(vitribandaux /Sprite.SCALED_SIZE)-1][(vitribandauy /Sprite.SCALED_SIZE)+1] ==0){
//                return true;
//            }
//            else return false;
//        }
//    }
//    public boolean diChuyenSangPhai(int vitribandaux,int vitribandauy,int dodichuyen){
//        if(vitribandaux % Sprite.SCALED_SIZE != 0) return true;
//        else if(vitribandauy % Sprite.SCALED_SIZE == 0){
//            if( a[(vitribandaux / Sprite.SCALED_SIZE) +1][(vitribandauy/Sprite.SCALED_SIZE)] == 0 ){
//                return true;
//            }
//            else return false;
//        }else{
//            if(a[(vitribandaux /Sprite.SCALED_SIZE )+1][(vitribandauy /Sprite.SCALED_SIZE)] ==0 && a[(vitribandaux /Sprite.SCALED_SIZE)+1][(vitribandauy /Sprite.SCALED_SIZE)+1] ==0){
//                return true;
//            }
//            else return false;
//        }
//    }
//    public boolean diChuyenLenTren(int vitribandaux,int vitribandauy,int dodichuyen){
//        if(vitribandauy % Sprite.SCALED_SIZE != 0) return true;
//        else if(vitribandaux % Sprite.SCALED_SIZE == 0){
//            if( a[(vitribandaux / Sprite.SCALED_SIZE) ][(vitribandauy/Sprite.SCALED_SIZE)-1] == 0 ){
//                return true;
//            }
//            else return false;
//        }else{
//            if(a[(vitribandaux /Sprite.SCALED_SIZE )][(vitribandauy /Sprite.SCALED_SIZE)-1] ==0 && a[(vitribandaux /Sprite.SCALED_SIZE)+1][(vitribandauy /Sprite.SCALED_SIZE)-1] ==0){
//                return true;
//            }
//            else return false;
//        }
//    }
//    public boolean diChuyenxuongduoi(int vitribandaux,int vitribandauy,int dodichuyen){
//        if(vitribandauy % Sprite.SCALED_SIZE != 0) return true;
//        else if(vitribandaux % Sprite.SCALED_SIZE == 0){
//            if( a[(vitribandaux / Sprite.SCALED_SIZE) ][(vitribandauy/Sprite.SCALED_SIZE)+1] == 0 ){
//                return true;
//            }
//            else return false;
//        }else{
//            if(a[(vitribandaux /Sprite.SCALED_SIZE )][(vitribandauy /Sprite.SCALED_SIZE)+1] ==0 && a[(vitribandaux /Sprite.SCALED_SIZE)+1][(vitribandauy /Sprite.SCALED_SIZE)+1] ==0){
//                return true;
//            }
//            else return false;
//        }
//    }
}
