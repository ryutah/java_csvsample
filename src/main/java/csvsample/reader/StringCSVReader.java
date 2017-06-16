package csvsample.reader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import csvsample.csv.reader.CSVReadException;

public class StringCSVReader implements CSVReader {
    private String csv;

    public StringCSVReader(String csv) {
        this.csv = csv;
    }

    @Override
    public List<String[]> read() {
        // TODO ダブルクォーテーション囲みや、カラム内改行のあるCSVが未対応 ちゃんとやるなら、真面目に構文解析的なことをしなきゃだめ。
        if (csv.isEmpty()) {
            return Collections.emptyList();
        }
        String[] rows = this.csv.split("\n");
        List<String[]> csv = Arrays.stream(rows)
                                   .map(r -> r.split(","))
                                   .collect(Collectors.toList());
        if (!this.isValid(csv)) {
            throw new CSVReadException();
        }
        return csv;
    }
}
