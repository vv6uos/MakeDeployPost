 
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
        result=title+"\n\n";
        for (String no : commitNo){
            if(no!=null){
                result+=no+"  ";
            }
        
        }

        for(String fileNm : file_path){
            result+="\n";
            if(fileNm!=null){result+=fileNm;}
        }

        return  result ; 
    }
    
}
