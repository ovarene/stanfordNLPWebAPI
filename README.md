# stanfordNLPWebAPI
Stanford NLP framework wrapped with a REST API.

# Usage

The output is in **text/turtle** format on both CLI and Web Service modes

## CLI :
java -jar StanfordNLP2NIF-X.Y.jar [pos|ner] -t "text to analyse"

## Web Service :
jar -jar StanfordNLP2NIF-X.Y.jar server <path/to/config.yaml>

# Configuration :

File in *src/main/resources/config.yaml*

```yaml
pipeline:
  annotators: "tokenize, ssplit, pos, lemma, ner"

  pos:
    model: "edu/stanford/nlp/models/pos-tagger/english-left3words/english-left3words-distsim.tagger"
  ner:
    model: "edu/stanford/nlp/models/ner/english.conll.4class.distsim.crf.ser.gz"
    useSUTime: false
    applyNumericClassifiers: false

  #parse_model: ""

logging:
  level: INFO
#  loggers:
#    "fr.eurecom.stanfordnlptonif.PosResource": DEBUG

server:
  applicationConnectors:
    - type: http
      port: 7000
  adminConnectors:
    - type: http
      port: 7001
```