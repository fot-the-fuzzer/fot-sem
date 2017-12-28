package tool;

import common.MutEnum;
import common.ParserNotFoundException;
import common.SemMutate;
import common.Utils;

import java.io.File;

/**
 * dump to stdout
 */
public class MutDumper {
    private File inFile;
    private String ext;
    private MutEnum mutEnum;

    MutDumper(CLIOptions cli) throws MutParseException {
        if (cli.inputFile.isDirectory()) {
            throw new MutParseException("for dumper, input file should not be a directory", cli);
        }
        this.inFile = cli.inputFile;
        if (ext != null) {
            this.ext = cli.ext;
        } else {
            this.ext = Utils.inferExt(inFile);
        }
        this.mutEnum = cli.mutEnum;
    }

    public void run() throws ParserNotFoundException {
        String name = inFile.getAbsolutePath();
        SemMutate semMutate = new SemMutate(this.inFile, this.ext);
        String mutatedText = semMutate.mutate(this.mutEnum);
        System.out.println(mutatedText);
    }

}
