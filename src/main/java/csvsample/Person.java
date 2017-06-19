package csvsample;

import java.util.Optional;

import csvsample.csv.Column;

public class Person implements Comparable<Person> {
    @Column(name = "会員No.")
    private String  accountNo;

    @Column(name = "氏名")
    private String  name;

    @Column(name = "性別")
    private String  sex;

    @Column(name = "推しメン")
    private String  oshimen;

    @Column(name = "ファン歴年数")
    private Integer fanYears;

    @Column(name = "年齢")
    private Integer age;

    @Column(name = "HEX_CODE")
    private String  hexCode;

    public String accountNo() {
        return this.valOrEmpty(this.accountNo);
    }

    public String name() {
        return this.valOrEmpty(this.name);
    }

    public String sex() {
        return this.valOrEmpty(this.sex);
    }

    public String oshimen() {
        return this.valOrEmpty(this.oshimen);
    }

    public Integer fanYears() {
        return this.valOrZero(this.fanYears);
    }

    public Integer age() {
        return this.valOrZero(this.age);
    }

    public String hexCode() {
        return this.valOrEmpty(this.hexCode);
    }

    private String valOrEmpty(String str) {
        return Optional.ofNullable(str).orElse("");
    }

    private Integer valOrZero(Integer i) {
        return Optional.ofNullable(i).orElse(0);
    }

    @Override
    public String toString() {
        return String.format("会員No = %s, 氏名 = %s, 性別 = %s, 推しメン = %s, ファン歴年数 = %s, 年齢 = %s, HEX_CODE =%s",
                             this.accountNo(),
                             this.name(),
                             this.sex(),
                             this.oshimen(),
                             this.fanYears(),
                             this.age(),
                             this.hexCode());
    }

    @Override
    public int compareTo(Person other) {
        return this.accountNo().compareTo(other.accountNo());
    }
}
