package csvsample.csv;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import csvsample.reader.CSVReader;
import csvsample.reader.FileCSVReader;
import csvsample.reader.StringCSVReader;

public class CSVParser {

    /**
     * CSV形式の文字列を、指定されたクラスのリストにパースする<br>
     * パース対象のクラスは、引数なしのコンストラクタを持つ必要がある。
     *
     * @param str
     * @param clazz
     * @return
     */
    public static <T> List<T> parse(String str, Class<T> clazz) {
        return parse(new StringCSVReader(str), clazz);
    }

    /**
     * CSVファイルを、指定されたクラスのリストにパースする<br>
     * パース対象のクラスは、引数なしのコンストラクタを持つ必要がある。
     *
     * @param str
     * @param clazz
     * @return
     */
    public static <T> List<T> parseFromFile(String filepath, Class<T> clazz) {
        return parse(new FileCSVReader(filepath), clazz);
    }

    public static <T> List<T> parse(CSVReader reader, Class<T> clazz) {
        CSV csv = new CSV(reader);
        return csv.stream().map(row -> CSVParser.create(row, clazz)).collect(Collectors.toList());
    }

    private static <T> T create(Row row, Class<T> clazz) {
        try {
            T obj = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            List<Field> columnFiells = Arrays.stream(fields).filter(CSVParser::isColmn).collect(Collectors.toList());
            columnFiells.forEach(f -> CSVParser.setColumnValue(row, obj, f));
            return obj;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new CSVParseException(e);
        }
    }

    private static boolean isColmn(Field field) {
        return field.getDeclaredAnnotation(Column.class) != null;
    }

    private static <T> void setColumnValue(Row row, T obj, Field field) {
        field.setAccessible(true);

        Column column = field.getDeclaredAnnotation(Column.class);
        String key = column.name();
        Optional<String> val = row.column(key);

        try {
            switch (field.getType().getSimpleName()) {
            case "Integer":
            case "int":
                if (val.isPresent()) {
                    Integer iVal = Integer.parseInt(val.get());
                    field.set(obj, iVal);
                }
                break;
            // TODO 小数とか日付型とか対応してもええんちゃうん
            default:
                field.set(obj, val.orElse(""));
            }

            field.setAccessible(false);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new CSVParseException(e);
        }
    }
}
