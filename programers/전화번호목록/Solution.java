package 전화번호목록;

class Solution {
    public boolean solution(String[] phone_book) {

        for(int i =0; i<phone_book.length-1; i++){
            for(int j=i+1; j<phone_book.length; j++){
                int len = Integer.min(phone_book[i].length(), phone_book[j].length());


                for (int pIdx = 0; pIdx < len; pIdx++) {
                    if(phone_book[i].charAt(pIdx) != phone_book[j].charAt(pIdx)){
                        break;
                    }if (pIdx+1==len){ return false;}
                }

//                if(phone_book[i].substring(0,len).equals(phone_book[j].substring(0,len))){
//                    return false;
//                }
            }
        }
        return true;
    }

}