// Generated from C:/Users/user/Desktop/졸업프로젝트/Code-obfuscation-tool/src/조인우/MiniC-Obfuscator/MiniC.g4 by ANTLR 4.13.2
package generated;


import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MiniCLexer extends Lexer {
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17,
            T__17 = 18, T__18 = 19, VOID = 20, INT = 21, WHILE = 22, IF = 23, ELSE = 24, RETURN = 25,
            OR = 26, AND = 27, LE = 28, GE = 29, EQ = 30, NE = 31, IDENT = 32, LITERAL = 33, DecimalConstant = 34,
            OctalConstant = 35, HexadecimalConstant = 36, WS = 37;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\u0004\u0000%\u00ce\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001" +
                    "\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004" +
                    "\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007" +
                    "\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b" +
                    "\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002" +
                    "\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002" +
                    "\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002" +
                    "\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002" +
                    "\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002" +
                    "\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002" +
                    "\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007" +
                    "!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0001\u0000\u0001\u0000" +
                    "\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003" +
                    "\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006" +
                    "\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001" +
                    "\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r" +
                    "\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001" +
                    "\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001" +
                    "\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001" +
                    "\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001" +
                    "\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001" +
                    "\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001" +
                    "\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001" +
                    "\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001" +
                    "\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001" +
                    "\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001" +
                    "\u001f\u0005\u001f\u00a6\b\u001f\n\u001f\f\u001f\u00a9\t\u001f\u0001 " +
                    "\u0001 \u0001 \u0003 \u00ae\b \u0001!\u0001!\u0001!\u0005!\u00b3\b!\n" +
                    "!\f!\u00b6\t!\u0003!\u00b8\b!\u0001\"\u0001\"\u0005\"\u00bc\b\"\n\"\f" +
                    "\"\u00bf\t\"\u0001#\u0001#\u0001#\u0004#\u00c4\b#\u000b#\f#\u00c5\u0001" +
                    "$\u0004$\u00c9\b$\u000b$\f$\u00ca\u0001$\u0001$\u0000\u0000%\u0001\u0001" +
                    "\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f" +
                    "\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f" +
                    "\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018" +
                    "1\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%\u0001\u0000" +
                    "\b\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u000019\u0001\u000009\u0001" +
                    "\u000007\u0002\u0000XXxx\u0003\u000009AFaf\u0003\u0000\t\n\r\r  \u00d5" +
                    "\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000" +
                    "\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000" +
                    "\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000" +
                    "\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011" +
                    "\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015" +
                    "\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019" +
                    "\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d" +
                    "\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001" +
                    "\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000" +
                    "\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000" +
                    "\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/" +
                    "\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000" +
                    "\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000" +
                    "\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=" +
                    "\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000" +
                    "\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000" +
                    "\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0001K" +
                    "\u0001\u0000\u0000\u0000\u0003M\u0001\u0000\u0000\u0000\u0005O\u0001\u0000" +
                    "\u0000\u0000\u0007Q\u0001\u0000\u0000\u0000\tS\u0001\u0000\u0000\u0000" +
                    "\u000bU\u0001\u0000\u0000\u0000\rW\u0001\u0000\u0000\u0000\u000fY\u0001" +
                    "\u0000\u0000\u0000\u0011[\u0001\u0000\u0000\u0000\u0013]\u0001\u0000\u0000" +
                    "\u0000\u0015_\u0001\u0000\u0000\u0000\u0017a\u0001\u0000\u0000\u0000\u0019" +
                    "d\u0001\u0000\u0000\u0000\u001bg\u0001\u0000\u0000\u0000\u001di\u0001" +
                    "\u0000\u0000\u0000\u001fk\u0001\u0000\u0000\u0000!m\u0001\u0000\u0000" +
                    "\u0000#o\u0001\u0000\u0000\u0000%q\u0001\u0000\u0000\u0000\'s\u0001\u0000" +
                    "\u0000\u0000)x\u0001\u0000\u0000\u0000+|\u0001\u0000\u0000\u0000-\u0082" +
                    "\u0001\u0000\u0000\u0000/\u0085\u0001\u0000\u0000\u00001\u008a\u0001\u0000" +
                    "\u0000\u00003\u0091\u0001\u0000\u0000\u00005\u0094\u0001\u0000\u0000\u0000" +
                    "7\u0097\u0001\u0000\u0000\u00009\u009a\u0001\u0000\u0000\u0000;\u009d" +
                    "\u0001\u0000\u0000\u0000=\u00a0\u0001\u0000\u0000\u0000?\u00a3\u0001\u0000" +
                    "\u0000\u0000A\u00ad\u0001\u0000\u0000\u0000C\u00b7\u0001\u0000\u0000\u0000" +
                    "E\u00b9\u0001\u0000\u0000\u0000G\u00c0\u0001\u0000\u0000\u0000I\u00c8" +
                    "\u0001\u0000\u0000\u0000KL\u0005;\u0000\u0000L\u0002\u0001\u0000\u0000" +
                    "\u0000MN\u0005=\u0000\u0000N\u0004\u0001\u0000\u0000\u0000OP\u0005[\u0000" +
                    "\u0000P\u0006\u0001\u0000\u0000\u0000QR\u0005]\u0000\u0000R\b\u0001\u0000" +
                    "\u0000\u0000ST\u0005(\u0000\u0000T\n\u0001\u0000\u0000\u0000UV\u0005)" +
                    "\u0000\u0000V\f\u0001\u0000\u0000\u0000WX\u0005,\u0000\u0000X\u000e\u0001" +
                    "\u0000\u0000\u0000YZ\u0005{\u0000\u0000Z\u0010\u0001\u0000\u0000\u0000" +
                    "[\\\u0005}\u0000\u0000\\\u0012\u0001\u0000\u0000\u0000]^\u0005-\u0000" +
                    "\u0000^\u0014\u0001\u0000\u0000\u0000_`\u0005+\u0000\u0000`\u0016\u0001" +
                    "\u0000\u0000\u0000ab\u0005-\u0000\u0000bc\u0005-\u0000\u0000c\u0018\u0001" +
                    "\u0000\u0000\u0000de\u0005+\u0000\u0000ef\u0005+\u0000\u0000f\u001a\u0001" +
                    "\u0000\u0000\u0000gh\u0005*\u0000\u0000h\u001c\u0001\u0000\u0000\u0000" +
                    "ij\u0005/\u0000\u0000j\u001e\u0001\u0000\u0000\u0000kl\u0005%\u0000\u0000" +
                    "l \u0001\u0000\u0000\u0000mn\u0005<\u0000\u0000n\"\u0001\u0000\u0000\u0000" +
                    "op\u0005>\u0000\u0000p$\u0001\u0000\u0000\u0000qr\u0005!\u0000\u0000r" +
                    "&\u0001\u0000\u0000\u0000st\u0005v\u0000\u0000tu\u0005o\u0000\u0000uv" +
                    "\u0005i\u0000\u0000vw\u0005d\u0000\u0000w(\u0001\u0000\u0000\u0000xy\u0005" +
                    "i\u0000\u0000yz\u0005n\u0000\u0000z{\u0005t\u0000\u0000{*\u0001\u0000" +
                    "\u0000\u0000|}\u0005w\u0000\u0000}~\u0005h\u0000\u0000~\u007f\u0005i\u0000" +
                    "\u0000\u007f\u0080\u0005l\u0000\u0000\u0080\u0081\u0005e\u0000\u0000\u0081" +
                    ",\u0001\u0000\u0000\u0000\u0082\u0083\u0005i\u0000\u0000\u0083\u0084\u0005" +
                    "f\u0000\u0000\u0084.\u0001\u0000\u0000\u0000\u0085\u0086\u0005e\u0000" +
                    "\u0000\u0086\u0087\u0005l\u0000\u0000\u0087\u0088\u0005s\u0000\u0000\u0088" +
                    "\u0089\u0005e\u0000\u0000\u00890\u0001\u0000\u0000\u0000\u008a\u008b\u0005" +
                    "r\u0000\u0000\u008b\u008c\u0005e\u0000\u0000\u008c\u008d\u0005t\u0000" +
                    "\u0000\u008d\u008e\u0005u\u0000\u0000\u008e\u008f\u0005r\u0000\u0000\u008f" +
                    "\u0090\u0005n\u0000\u0000\u00902\u0001\u0000\u0000\u0000\u0091\u0092\u0005" +
                    "|\u0000\u0000\u0092\u0093\u0005|\u0000\u0000\u00934\u0001\u0000\u0000" +
                    "\u0000\u0094\u0095\u0005&\u0000\u0000\u0095\u0096\u0005&\u0000\u0000\u0096" +
                    "6\u0001\u0000\u0000\u0000\u0097\u0098\u0005<\u0000\u0000\u0098\u0099\u0005" +
                    "=\u0000\u0000\u00998\u0001\u0000\u0000\u0000\u009a\u009b\u0005>\u0000" +
                    "\u0000\u009b\u009c\u0005=\u0000\u0000\u009c:\u0001\u0000\u0000\u0000\u009d" +
                    "\u009e\u0005=\u0000\u0000\u009e\u009f\u0005=\u0000\u0000\u009f<\u0001" +
                    "\u0000\u0000\u0000\u00a0\u00a1\u0005!\u0000\u0000\u00a1\u00a2\u0005=\u0000" +
                    "\u0000\u00a2>\u0001\u0000\u0000\u0000\u00a3\u00a7\u0007\u0000\u0000\u0000" +
                    "\u00a4\u00a6\u0007\u0001\u0000\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000" +
                    "\u00a6\u00a9\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000" +
                    "\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8@\u0001\u0000\u0000\u0000\u00a9" +
                    "\u00a7\u0001\u0000\u0000\u0000\u00aa\u00ae\u0003C!\u0000\u00ab\u00ae\u0003" +
                    "E\"\u0000\u00ac\u00ae\u0003G#\u0000\u00ad\u00aa\u0001\u0000\u0000\u0000" +
                    "\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000" +
                    "\u00aeB\u0001\u0000\u0000\u0000\u00af\u00b8\u00050\u0000\u0000\u00b0\u00b4" +
                    "\u0007\u0002\u0000\u0000\u00b1\u00b3\u0007\u0003\u0000\u0000\u00b2\u00b1" +
                    "\u0001\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000\u0000\u0000\u00b4\u00b2" +
                    "\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b8" +
                    "\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7\u00af" +
                    "\u0001\u0000\u0000\u0000\u00b7\u00b0\u0001\u0000\u0000\u0000\u00b8D\u0001" +
                    "\u0000\u0000\u0000\u00b9\u00bd\u00050\u0000\u0000\u00ba\u00bc\u0007\u0004" +
                    "\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bf\u0001\u0000" +
                    "\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000" +
                    "\u0000\u0000\u00beF\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000" +
                    "\u0000\u00c0\u00c1\u00050\u0000\u0000\u00c1\u00c3\u0007\u0005\u0000\u0000" +
                    "\u00c2\u00c4\u0007\u0006\u0000\u0000\u00c3\u00c2\u0001\u0000\u0000\u0000" +
                    "\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000" +
                    "\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6H\u0001\u0000\u0000\u0000\u00c7" +
                    "\u00c9\u0007\u0007\u0000\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9" +
                    "\u00ca\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00ca" +
                    "\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc" +
                    "\u00cd\u0006$\u0000\u0000\u00cdJ\u0001\u0000\u0000\u0000\t\u0000\u00a5" +
                    "\u00a7\u00ad\u00b4\u00b7\u00bd\u00c5\u00ca\u0001\u0000\u0001\u0000";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    static {
        RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION);
    }

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public MiniCLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8",
                "T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16",
                "T__17", "T__18", "VOID", "INT", "WHILE", "IF", "ELSE", "RETURN", "OR",
                "AND", "LE", "GE", "EQ", "NE", "IDENT", "LITERAL", "DecimalConstant",
                "OctalConstant", "HexadecimalConstant", "WS"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "';'", "'='", "'['", "']'", "'('", "')'", "','", "'{'", "'}'",
                "'-'", "'+'", "'--'", "'++'", "'*'", "'/'", "'%'", "'<'", "'>'", "'!'",
                "'void'", "'int'", "'while'", "'if'", "'else'", "'return'", "'||'", "'&&'",
                "'<='", "'>='", "'=='", "'!='"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, "VOID", "INT", "WHILE",
                "IF", "ELSE", "RETURN", "OR", "AND", "LE", "GE", "EQ", "NE", "IDENT",
                "LITERAL", "DecimalConstant", "OctalConstant", "HexadecimalConstant",
                "WS"
        };
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "MiniC.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }
}