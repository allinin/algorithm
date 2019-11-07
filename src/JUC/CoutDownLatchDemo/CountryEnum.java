package JUC.CoutDownLatchDemo;

public enum CountryEnum {

    ONE(1,"齐"),
    TWO(2,"楚"),
    THREE(3,"燕"),
    FOUR(4,"赵"),
    FIVE(5,"魏"),
    SIX(6,"韩");

    CountryEnum(Integer code,String name)
    {
        this.code=code;
        this.name=name;
    }


    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     public static CountryEnum forEach(int index) {
         CountryEnum[] countryEnums = CountryEnum.values();//返回枚举数组
         for (CountryEnum countryEnum : countryEnums) {
             if (index == countryEnum.getCode())
                 return countryEnum;
         }
         return null;
     }

}
