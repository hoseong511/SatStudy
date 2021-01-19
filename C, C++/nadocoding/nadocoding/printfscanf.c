//
//  main.c
//  printfscanf
//
//  Created by Ho Ho on 2021/01/19.
// 유튜브 나도코딩 https://www.youtube.com/watch?v=q6fPjQAzll8&t=22335s&ab_channel=%EB%82%98%EB%8F%84%EC%BD%94%EB%94%A9

#include <stdio.h>

int printfscanf(void) {
    // insert code here...
    // 정수형 변수에 대한 예제
//    int age = 12;
//
//    printf("%d\n", age);
//    age = 13;
//    printf("%d\n", age);
//
//    // 실수형 변수에 대한 예제
//    float f = 46.5;
//    printf("%f\n",f   );
//
//    // scanf
//    // 키보드 입력을 받아서 저장
//    int input;
//    printf("값을 입력하세요 : ");
//    scanf("%d", &input);
//    printf("입력값 : %d\n", input);
//    int one, two, three;
//    printf("3개의 정수를 입력하세요 : ");
//    scanf("%d %d %d", &one, &two, &three);
//    printf("첫번째 값 : %d\n", one);
//    printf("두번째 값 : %d\n", two);
//    printf("세번째 값 : %d\n", three);
    
    // 문자(한 글자), 문자열(한 글자 이상의 여러 글자) --> char, string
    char c = 'A';
    printf("%c\n", c);
    
    char str[256];
    scanf("%s", str, sizeof(str));
    printf("%s\n", str);
    printf("con");
    
    // 프로젝트
    // 경찰관이 범죄자의 정보를 입수 (조서 작성)
    // 이름? 나이? 몸무게? 키? 범죄명?
    char name[256];
    printf("이름?");
    scanf("%s", name, sizeof(name));
    
    int age;
    printf("나이?");
    scanf("%d", &age);
    
    float weight;
    printf("몸무게는 몇 kg?");
    scanf("%f", &weight);
    
    double height;
    printf("키는 몇 cm?");
    scanf("%lf", &height);
    
    char what[256];
    printf("무슨 범죄?");
    scanf("%s", what, sizeof(what));
    
    // 조서 내용 출력
    printf("\n\n ------- 범죄자 정보 -------- \n\n");
    printf("이름  : %s\n", name);
    printf("나이  : %d\n", age);
    printf("몸무게  : %.2f\n", weight);
    printf("키 : %.2lf\n", height);
    printf("범죄  : %s\n", what);
    
    
    return 0;
}
