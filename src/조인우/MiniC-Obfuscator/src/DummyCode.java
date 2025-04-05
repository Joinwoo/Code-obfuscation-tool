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
            "((lMnOpQrStUv+XyZaBcDeFgH)>(qRsTuVwXyZ-DeFgHiJkLmN))",
            "((OpQrStUvWxY*aBcDeFgHiJk2)>(lMnOpQrStUv2/dUmMyVaRiAbL))",
            "(((RaNdOmVaLuE1&RaNdOmVaLuE2)^0xF0)==0x12345678)",
            "(((lMnOpQrStUv2>>2)-(aBcDeFgHiJk2*2))==(RaNdOmVaLuE2|dUmMyVaRiAbL))",
            "((((qRsTuVwXyZ+OpQrStUvWxY)*3)&0xFF)==(lMnOpQrStUv2>>3))",
            "((((RaNdOmVaLuE1>>4)&0xFFF)^0xABC)<(XyZaBcDeFgH*dUmMyVaRiAbL))"
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
