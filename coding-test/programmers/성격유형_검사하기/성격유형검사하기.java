package 성격유형_검사하기;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] result = new int[4];

        for(int i =0; i<choices.length;i++){
            switch(survey[i]){
                case"RT":
                    result[0]+=(choices[i]-4);
                    break;
                case"TR":
                    result[0]-=(choices[i]-4);
                    break;
                case"FC":
                    result[1]+=(choices[i]-4);
                    break;
                case"CF":
                    result[1]-=(choices[i]-4);
                    break;
                case"MJ":
                    result[2]+=(choices[i]-4);
                    break;
                case"JM":
                    result[2]-=(choices[i]-4);
                    break;
                case"AN":
                    result[3]+=(choices[i]-4);
                    break;
                case"NA":
                    result[3]-=(choices[i]-4);
                    break;

            }
        }
        if(result[0]<=0){
            answer+="R";
        }else{
            answer+="T";
        }
        if(result[1]<0){
            answer+="F";
        }else{
            answer+="C";
        }
        if(result[2]<0){
            answer+="M";
        }else{
            answer+="J";
        }
        if(result[3]<=0){
            answer+="A";
        }else{
            answer+="N";
        }


        return answer;
    }
}