package fr.eurecom.stanfordnlptonif.command;

import fr.eurecom.stanfordnlptonif.core.*;
import fr.eurecom.stanfordnlptonif.enums.*;
import io.dropwizard.cli.*;
import io.dropwizard.setup.*;
import net.sourceforge.argparse4j.inf.*;
import org.apache.jena.riot.*;
import org.slf4j.*;

import java.util.*;

/**
 * NER CLI
 */
public class NerCommand extends Command {

  private static final Logger LOGGER = LoggerFactory.getLogger(NerCommand.class);

  private Pipeline pipeline;

  public NerCommand() {
    super("ner", "ner command on text");
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner");
    this.pipeline = new Pipeline(props);
  }

  @Override
  public void configure(Subparser subparser) {
    // Add a command line option
    subparser.addArgument("-t")
        .dest("text")
        .type(String.class)
        .required(true)
        .help("text to analyse");
  }

  @Override
  public void run(Bootstrap<?> bootstrap, Namespace namespace) throws Exception {
    System.out.println("POS analysis on \"" + namespace.getString("text") + "\" :\n" );
    System.out.println(this.pipeline.run(namespace.getString("text")).rdfString("stanfordnlp", RDFFormat.TURTLE_PRETTY, NlpProcess.NER));
  }
}
