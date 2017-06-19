# 6/14(水) ソースレビュー会 リファクタリング by ryutah

## 実行
```console
$ cd $PROJECT_ROOT
$ gradlew run
```

## テスト実行
```console
$ cd $PROJECT_ROOT
$ gradlew test
```

## 課題とか
* ダブルクォーテーション囲いのCSV未対応
* カラム内改行とか未対応
* CSV最終行に改行が入るか入らないか考えてない
* CSVWriterクラスとか作って、CSV出力対応する
* あまりAPIの使用感を検証できてない
