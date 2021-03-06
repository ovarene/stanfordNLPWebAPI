package fr.eurecom.stanfordnlptonif.command;

import fr.eurecom.stanfordnlptonif.core.*;
import fr.eurecom.stanfordnlptonif.enums.*;
import io.dropwizard.cli.*;
import io.dropwizard.setup.*;
import org.apache.jena.riot.*;
import org.slf4j.*;
import net.sourceforge.argparse4j.inf.*;

import java.util.*;

/**
 * POS CLI
 */
public class PosCommand extends Command {

  private static final Logger LOGGER = LoggerFactory.getLogger(PosCommand.class);

  private Pipeline pipeline;

  public PosCommand() {
    super("pos", "pos command on text");
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
    System.out.println(this.pipeline.run(namespace.getString("text")).rdfString("stanfordnlp", RDFFormat.TURTLE_PRETTY, NlpProcess.POS));
  }
}
