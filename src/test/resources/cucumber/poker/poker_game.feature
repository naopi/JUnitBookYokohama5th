# language: ja
フィーチャ: ポーカーゲーム
  シナリオテンプレート: ノーチェンジの場合
    前提 手札に<手札>が配られた
    もし チェンジしない
    ならば <役>であるべき

  例:
    | 手札                 | 役       |
    | S1, H4, D6, D8, C3   | ノーペア |
    | D2, C6, S7, S3, S8   | ノーペア |
    | D1, D3, D5, S1, C4   | 1のワンペア |
    | D2, C2, D1, S13, C12 | 2のワンペア |
    | D3, D9, S3, S5, H3   | 3のスリーカード |
    | D4, C6, D8, S6, C4   | 4と6のツーペア |
    | D6, C6, D4, S4, C8   | 6と4のツーペア |

