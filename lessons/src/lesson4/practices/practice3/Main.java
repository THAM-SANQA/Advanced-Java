package lesson4.practices.practice3;

public class Main {
  public static void main(String[] args) {
    PeerSingleton peer01 = PeerSingleton.getInstance();
    PeerSingleton peer02 = PeerSingleton.getInstance();

    for(String hostName: peer01.getHostNames()) {
      System.out.println("Host Name: " + hostName);
    }

    System.out.println();

    for(String hostName: peer02.getHostNames()) {
      System.out.println("Host Name: " + hostName);
    }
  }  
}
