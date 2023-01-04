import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class Converter {
    public String toText(String str){
        String[] strArr = str.split("\n");
        int commitNum= str.split("rev").length-1;
        int commitIndex=0;
        var fileIndex=0;
        String title ="";
        String[] commitNo=new String[commitNum];
        String[] file_path=new String[strArr.length-commitNum];
        String result="";
        for(String sentence:strArr){
            if(sentence.contains("[[")){
                file_path[fileIndex]=sentence;
                fileIndex++;
            }else if (sentence.contains("rev")){
                commitNo[commitIndex]=sentence;
                commitIndex++;
            }else if (sentence.contains("#")){
                if(title==""){title=sentence;}
            }
        }
        //파일 중복 확인 , 순서 정리 
        //나중에 dll,cshtml, js, sql
        LinkedHashSet<String> linkedHashSet= new LinkedHashSet<>(Arrays.asList(file_path));
        String[] fileList=linkedHashSet.toArray(new String[] {});
        //null빼고 해야되서 배열 위치 선정 
        Arrays.sort(fileList,0,fileList.length-1);

        //출력 부분 
        //타이틀 수정 필요 
        result=title+"\n\n";
        for (String no : commitNo){
            if(no!=null){
                result+=no+"  ";
            }
        
        }
        // 수정 필요 
        for(String fileNm : fileList){
            result+="\n";
            if(fileNm!=null){result+=fileNm;}
        }

        return  result ; 
    }
    
}
