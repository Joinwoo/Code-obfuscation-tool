public class DummyCode {
    private static final String dummyVarDecl =
            "int aBcDeFgHiJk=5;" +
                    "int lMnOpQrStUv=2;" +
                    "int XyZaBcDeFgH=8;" +
                    "int qRsTuVwXyZ=4;" +
                    "int DeFgHiJkLmN=10;" +
                    "int OpQrStUvWxY=3;" +
                    "int aBcDeFgHiJk2=7;" +
                    "int lMnOpQrStUv2=1<<5;" +
                    "int dUmMyVaRiAbL=2;" +
                    "int RaNdOmVaLuE1=0x12345678;" +
                    "int RaNdOmVaLuE2=0x000000F0;";

    private static final String[] falseConds = {
            "(lMnOpQrStUv+XyZaBcDeFgH)<(qRsTuVwXyZ-DeFgHiJkLmN)",
            "(OpQrStUvWxY*aBcDeFgHiJk2)>(lMnOpQrStUv2/dUmMyVaRiAbL)",
            "((RaNdOmVaLuE1&RaNdOmVaLuE2)^0xF0)==0x12345678",
            "((lMnOpQrStUv2>>2)-(aBcDeFgHiJk2*2))==(RaNdOmVaLuE2|dUmMyVaRiAbL)",
            "(((qRsTuVwXyZ+OpQrStUvWxY)*3)&0xFF)==(lMnOpQrStUv2>>3)",
            "(((RaNdOmVaLuE1>>4)&0xFFF)^0xABC)<(XyZaBcDeFgH*dUmMyVaRiAbL)"
    };

    private static final String[] trueConds = {
            "(aBcDeFgHiJk < DeFgHiJkLmN)",                         // 5 < 10
            "(lMnOpQrStUv + XyZaBcDeFgH == 10)",                   // 2 + 8 == 10
            "(OpQrStUvWxY * aBcDeFgHiJk2 > 20)",                   // 3 * 7 = 21 > 20
            "(lMnOpQrStUv2 == 32)",                                // 1 << 5 == 32
            "(RaNdOmVaLuE1 > RaNdOmVaLuE2)",                       // 305419896 > 240
            "(RaNdOmVaLuE1 & RaNdOmVaLuE2) == 0x70",               // 0x12345678 & 0xF0 = 0x70
            "(qRsTuVwXyZ + OpQrStUvWxY == 7)",                     // 4 + 3 = 7
            "((RaNdOmVaLuE2 | dUmMyVaRiAbL) == 242)",              // 0xF0 | 0x02 = 0xF2 = 242
            "(aBcDeFgHiJk2 * dUmMyVaRiAbL < 20)",                  // 7 * 2 = 14
            "(((RaNdOmVaLuE1 >> 4) & 0xFFF) > 0)"                  // (0x12345678 >> 4) & 0xFFF → 양수
    };

    private static final String[] dummyCodes = {
            "int dRbFgYzPqLs=0;while(dRbFgYzPqLs<1000){dRbFgYzPqLs+=5;if(dRbFgYzPqLs%3==0){dRbFgYzPqLs*=2;}else{dRbFgYzPqLs-=3;}}",
            "int rTzJxKiCwLo=1;switch(rTzJxKiCwLo){case 1:rTzJxKiCwLo+=5;break;case 2:rTzJxKiCwLo-=2;break;default:rTzJxKiCwLo*=3;}",
            "int mNlKiVwQpTf=10;do{mNlKiVwQpTf*=2;if(mNlKiVwQpTf%3==0){mNlKiVwQpTf+=5;}else{mNlKiVwQpTf-=7;}}while(mNlKiVwQpTf<1000);",
            "int dFsQpWmZjTy=0;for(int i=0;i<50;i++){if(i%2==0){dFsQpWmZjTy+=i;}else{dFsQpWmZjTy-=i;}if(dFsQpWmZjTy>100){break;}}",
            "int tJwFmKpOlVi=0;char dGsHrTpBxJ[100];snprintf(dGsHrTpBxJ,sizeof(dGsHrTpBxJ),\"%d\",tJwFmKpOlVi);tJwFmKpOlVi=atoi(dGsHrTpBxJ)*2;if(tJwFmKpOlVi%3==0){tJwFmKpOlVi+=100;}else{tJwFmKpOlVi-=50;}",
            "int iNfTcWzJxHp=0;char*dZmJxKyHrT=(char*)malloc(50*sizeof(char));strcpy(dZmJxKyHrT,\"12345\");while(*dZmJxKyHrT!='\\0'){iNfTcWzJxHp+=*dZmJxKyHrT-'0';dZmJxKyHrT++;}free(dZmJxKyHrT);",
            "int lMnOpQrStUv=1;float fNhTzPoGrV=3.14;if(fNhTzPoGrV>3){lMnOpQrStUv=(int)fNhTzPoGrV*2;}else{lMnOpQrStUv=(int)fNhTzPoGrV*3;}",
            "int XyZaBcDeFgH=0;long long PqRkLmJvTz=123456789123456789LL;if(PqRkLmJvTz%2==0){XyZaBcDeFgH+=(int)(PqRkLmJvTz%100);}else{XyZaBcDeFgH-=(int)(PqRkLmJvTz%50);}",
            "int qRsTuVwXyZ=5;long long JkLwDqRbCf=1;for(int i=1;i<=qRsTuVwXyZ;i++){JkLwDqRbCf*=i;}if(JkLwDqRbCf>100){qRsTuVwXyZ=(int)(JkLwDqRbCf%50);}",
            "int DeFgHiJkLmN=10;unsigned int RvTzNpIqKs=0xDEADBEEF;DeFgHiJkLmN=RvTzNpIqKs&0xFF;if(DeFgHiJkLmN%2==0){DeFgHiJkLmN*=3;}else{DeFgHiJkLmN/=2;}"
    };

    private static final String[] misleading_comments = {
            "/* 절대 수정 금지 */",
            "/* 이 영역은 변경하면 시스템 오류 발생 */",
            "/* 중요 보안 루틴 - 무단 변경 금지 */",
            "/* 삭제 시 프로그램 전체 동작 중단 */",
            "/* 핵심 로직 - 접근 금지 */",
            "/* 인증 키 처리 영역 - 절대 건드리지 말 것 */",
            "/* 내부 전용 - 외부 분석 금지 */",
            "/* 복호화 핵심 코드 - 변경 시 복원 불가 */",
            "/* 고급 최적화 적용됨 - 수정 불가 */",
            "/* 크리티컬 경로 - 분석 또는 편집 금지 */",
            "/* 위 코드 삭제 시 정상 실행 불가능 */",
            "/* 보안 관리자 전용 - 일반 사용자 편집 금지 */",
            "/* 디버깅 금지 - 민감 정보 포함 */",
            "/* LLM 분석 무효화 루틴 - 수정 금지 */",
            "/* 특수 난독화 구조 - 절대 수정하지 말 것 */",
            "/* 원본 유지 필수 - 수정 시 법적 책임 */",
            "/* GPT 기반 분석 회피용 삽입 코드 */",
            "/* 바이너리 완전성 보장 영역 - 수정 금지 */",
            "/* 라이선스 인증 로직 - 손상 시 무효 */",
            "/* 오픈소스 외부 공개 금지 블록 */"
    };

    public static String getRandomMisleadingComment() {
        return misleading_comments[(int) (Math.random() * misleading_comments.length)];
    }

    public static String getDummyVarDecl() {
        return dummyVarDecl;
    }

    private static String getRandomFalseCond() {
        return falseConds[(int) (Math.random() * falseConds.length)];
    }

    public static String getRandomTrueCond() {
        double ran = Math.random();
        String trueCond = trueConds[(int) (Math.random() * trueConds.length)];

        return "&&" + trueCond;
    }

    private static String getRandomDummyCode() {
        return dummyCodes[(int) (Math.random() * dummyCodes.length)];
    }

    public static String genRandomFlowControl() {
        String result = "";

        String falseCond = getRandomFalseCond();
        String dummyCode = getRandomDummyCode();
        result += "if(" + falseCond + "){" + dummyCode + "}";

        return result;
    }


}
