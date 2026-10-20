package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int idx = 1;
        Scanner scan = new Scanner(System.in);
        List<WiseSaying> list = new ArrayList<>();

        System.out.println("== 명언 앱 ==");
        while(true){
            System.out.print("명령) ");
            String answer = scan.nextLine().trim();

            if(answer.equals("등록")){
                System.out.print("명언: ");
                String line = scan.nextLine().trim();
                System.out.print("작가: ");
                String auth = scan.nextLine().trim();

                WiseSaying wise = new WiseSaying(idx, line, auth);
                list.add(wise);
                System.out.println(idx + "번 명언이 등록되었습니다.");
                idx++;
            }else if(answer.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("--------------------------");

                if(list.isEmpty()){
                    System.out.println("비어 있음");
                }

                for(int i = list.size(); i > 0; i--){
                    WiseSaying wise = list.get(i - 1);
                    System.out.println(wise.num() + " / " + wise.auth() + " / " + wise.line());
                }
            }else if(answer.equals("종료")){
                System.out.println("시스템을 종료합니다.");
                break;
            }else{
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}

record WiseSaying(int num, String line, String auth){
    WiseSaying wither(String line, String auth){
        return new WiseSaying(this.num, line, auth);
    }
}