package lesson6.practices.practice6_3;

public class AnalyzerTool {
  
  public void showResult(String[] strList, String searchStr, StringAnalyzer analyzer){
    for(String current:strList){
      if (analyzer.analyze(current, searchStr)){
        System.out.println("Match: " + current);
      }
    }
  }
}
