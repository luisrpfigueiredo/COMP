/* Generated By:JJTree&JavaCC: Do not edit this line. Matrix.java */
package Matrix;


import java.util.Hashtable;
import java.util.HashMap;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import semantica.Semantica;
import codeGeneration.CodeGenerator;

public class Matrix/*@bgen(jjtree)*/implements MatrixTreeConstants, MatrixConstants {/*@bgen(jjtree)*/
  protected static JJTMatrixState jjtree = new JJTMatrixState();public static String currentSymbol;
  public static String currentSymbolString;
  public static Hashtable<String, String> symbolTable;

        public static void percorreGrafo(Node node, String prefix) {

                        SimpleNode n = (SimpleNode) node;

                        Object obj = n.jjtGetValue();
                        System.out.println(prefix + n.toString() + "-" + obj);

                        for(int i = 0; i < n.jjtGetNumChildren(); i++) {
                                percorreGrafo(n.jjtGetChild(i), prefix + "\u005ct");
                        }
                }

  public static void main(String args [])throws Exception
  {

    Matrix parser = new Matrix(System.in);
        SimpleNode root = parser.S();

        Semantica semantica= new Semantica();
        semantica.analise(root);
        HashMap<String, double[][]> inputTable = semantica.getInputTable();

        percorreGrafo(root, ": ");
        CodeGenerator generator = new CodeGenerator(inputTable,root,semantica.getOutputName());
        generator.generate();
        generator.closeOutput();

        System.out.println("Ficheiro criado\u005cn");



  }

  static final public SimpleNode S() throws ParseException {
                  /*@bgen(jjtree) S */
  SimpleNode jjtn000 = new SimpleNode(JJTS);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      Expr();
      jj_consume_token(LF);
    jjtree.closeNodeScope(jjtn000, true);
    jjtc000 = false;
    {if (true) return jjtn000;}
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
    throw new Error("Missing return statement in function");
  }

  static final public void Expr() throws ParseException {
                   Token i;
    label_1:
    while (true) {
      Input();
      jj_consume_token(LF);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INPUT:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
    }
    Output();
  }

  static final public void Input() throws ParseException {
                      /*@bgen(jjtree) input */
                      SimpleNode jjtn000 = new SimpleNode(JJTINPUT);
                      boolean jjtc000 = true;
                      jjtree.openNodeScope(jjtn000);Token i;
    try {
      jj_consume_token(INPUT);
      i = jj_consume_token(SYMBOL);
        jjtn000.jjtSetValue( i.image);
      jj_consume_token(DOUBLE_POINT);
      Array();
      jj_consume_token(22);
    } catch (Throwable jjte000) {
     if (jjtc000) {
       jjtree.clearNodeScope(jjtn000);
       jjtc000 = false;
     } else {
       jjtree.popNode();
     }
     if (jjte000 instanceof RuntimeException) {
       {if (true) throw (RuntimeException)jjte000;}
     }
     if (jjte000 instanceof ParseException) {
       {if (true) throw (ParseException)jjte000;}
     }
     {if (true) throw (Error)jjte000;}
    } finally {
     if (jjtc000) {
       jjtree.closeNodeScope(jjtn000, true);
     }
    }
  }

  static final public void Output() throws ParseException {
                        /*@bgen(jjtree) output */
                        SimpleNode jjtn000 = new SimpleNode(JJTOUTPUT);
                        boolean jjtc000 = true;
                        jjtree.openNodeScope(jjtn000);Token i;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OUTPUT:
        jj_consume_token(OUTPUT);
        i = jj_consume_token(SYMBOL);
        jjtn000.jjtSetValue(i.image);
        jj_consume_token(DOUBLE_POINT);
        MathExpression();
        jj_consume_token(22);
        break;
      default:
        jj_la1[1] = jj_gen;
        ;
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void Array() throws ParseException {
                   Token i;
    jj_consume_token(BRACKET_LEFT);
    InnerArray();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 23:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      jj_consume_token(23);
      InnerArray();
    }
    jj_consume_token(BRACKET_RIGHT);
  }

  static final public void InnerArray() throws ParseException {
                   /*@bgen(jjtree) InnerArray */
  SimpleNode jjtn000 = new SimpleNode(JJTINNERARRAY);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(BRACKET_LEFT);
      Term();
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 23:
          ;
          break;
        default:
          jj_la1[3] = jj_gen;
          break label_3;
        }
        jj_consume_token(23);
        Term();
      }
      jj_consume_token(BRACKET_RIGHT);
    } catch (Throwable jjte000) {
     if (jjtc000) {
       jjtree.clearNodeScope(jjtn000);
       jjtc000 = false;
     } else {
       jjtree.popNode();
     }
     if (jjte000 instanceof RuntimeException) {
       {if (true) throw (RuntimeException)jjte000;}
     }
     if (jjte000 instanceof ParseException) {
       {if (true) throw (ParseException)jjte000;}
     }
     {if (true) throw (Error)jjte000;}
    } finally {
     if (jjtc000) {
       jjtree.closeNodeScope(jjtn000, true);
     }
    }
  }

  static final public void Term() throws ParseException {
             /*@bgen(jjtree) Term */
             SimpleNode jjtn000 = new SimpleNode(JJTTERM);
             boolean jjtc000 = true;
             jjtree.openNodeScope(jjtn000);Token i;
    try {
      i = jj_consume_token(DOUBLE);
                jjtree.closeNodeScope(jjtn000, true);
                jjtc000 = false;
        jjtn000.jjtSetValue(Double.parseDouble(i.image));
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  static final public void MathExpression() throws ParseException {
    label_4:
    while (true) {
      Priority1(1);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PARENTHESIS_LEFT:
      case SYMBOL:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_4;
      }
    }
  }

  static final public void Priority1(int sign) throws ParseException {
    Priority2(sign);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
    case MINUS:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
                     SimpleNode jjtn001 = new SimpleNode(JJTADD);
                     boolean jjtc001 = true;
                     jjtree.openNodeScope(jjtn001);
        try {
          Priority2(1);
        } catch (Throwable jjte001) {
                     if (jjtc001) {
                       jjtree.clearNodeScope(jjtn001);
                       jjtc001 = false;
                     } else {
                       jjtree.popNode();
                     }
                     if (jjte001 instanceof RuntimeException) {
                       {if (true) throw (RuntimeException)jjte001;}
                     }
                     if (jjte001 instanceof ParseException) {
                       {if (true) throw (ParseException)jjte001;}
                     }
                     {if (true) throw (Error)jjte001;}
        } finally {
                     if (jjtc001) {
                       jjtree.closeNodeScope(jjtn001,  2);
                     }
        }
        break;
      case MINUS:
        jj_consume_token(MINUS);
                      SimpleNode jjtn002 = new SimpleNode(JJTSUB);
                      boolean jjtc002 = true;
                      jjtree.openNodeScope(jjtn002);
        try {
          Priority2(1);
        } catch (Throwable jjte002) {
                      if (jjtc002) {
                        jjtree.clearNodeScope(jjtn002);
                        jjtc002 = false;
                      } else {
                        jjtree.popNode();
                      }
                      if (jjte002 instanceof RuntimeException) {
                        {if (true) throw (RuntimeException)jjte002;}
                      }
                      if (jjte002 instanceof ParseException) {
                        {if (true) throw (ParseException)jjte002;}
                      }
                      {if (true) throw (Error)jjte002;}
        } finally {
                      if (jjtc002) {
                        jjtree.closeNodeScope(jjtn002,  2);
                      }
        }
        break;
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[6] = jj_gen;
      ;
    }
  }

  static final public void Priority2(int sign) throws ParseException {
    Priority3(sign);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MULTIPLY:
      jj_consume_token(MULTIPLY);
   SimpleNode jjtn001 = new SimpleNode(JJTMUL);
   boolean jjtc001 = true;
   jjtree.openNodeScope(jjtn001);
      try {
        Priority3(1);
      } catch (Throwable jjte001) {
   if (jjtc001) {
     jjtree.clearNodeScope(jjtn001);
     jjtc001 = false;
   } else {
     jjtree.popNode();
   }
   if (jjte001 instanceof RuntimeException) {
     {if (true) throw (RuntimeException)jjte001;}
   }
   if (jjte001 instanceof ParseException) {
     {if (true) throw (ParseException)jjte001;}
   }
   {if (true) throw (Error)jjte001;}
      } finally {
   if (jjtc001) {
     jjtree.closeNodeScope(jjtn001,  2);
   }
      }
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
  }

  static final public void Priority3(int sign) throws ParseException {
    Priority4(sign);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRANSPOSE:
          SimpleNode jjtn001 = new SimpleNode(JJTTRA);
          boolean jjtc001 = true;
          jjtree.openNodeScope(jjtn001);
      try {
        jj_consume_token(TRANSPOSE);
      } finally {
          if (jjtc001) {
            jjtree.closeNodeScope(jjtn001,  1);
          }
      }
      afterTranspose(sign);
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
  }

  static final public void afterTranspose(int sign) throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
    case MINUS:
    case MULTIPLY:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
                      SimpleNode jjtn001 = new SimpleNode(JJTADD);
                      boolean jjtc001 = true;
                      jjtree.openNodeScope(jjtn001);
        try {
          Priority4(sign);
        } catch (Throwable jjte001) {
                      if (jjtc001) {
                        jjtree.clearNodeScope(jjtn001);
                        jjtc001 = false;
                      } else {
                        jjtree.popNode();
                      }
                      if (jjte001 instanceof RuntimeException) {
                        {if (true) throw (RuntimeException)jjte001;}
                      }
                      if (jjte001 instanceof ParseException) {
                        {if (true) throw (ParseException)jjte001;}
                      }
                      {if (true) throw (Error)jjte001;}
        } finally {
                      if (jjtc001) {
                        jjtree.closeNodeScope(jjtn001,  2);
                      }
        }
        break;
      case MINUS:
        jj_consume_token(MINUS);
                       SimpleNode jjtn002 = new SimpleNode(JJTSUB);
                       boolean jjtc002 = true;
                       jjtree.openNodeScope(jjtn002);
        try {
          Priority4(sign);
        } catch (Throwable jjte002) {
                       if (jjtc002) {
                         jjtree.clearNodeScope(jjtn002);
                         jjtc002 = false;
                       } else {
                         jjtree.popNode();
                       }
                       if (jjte002 instanceof RuntimeException) {
                         {if (true) throw (RuntimeException)jjte002;}
                       }
                       if (jjte002 instanceof ParseException) {
                         {if (true) throw (ParseException)jjte002;}
                       }
                       {if (true) throw (Error)jjte002;}
        } finally {
                       if (jjtc002) {
                         jjtree.closeNodeScope(jjtn002,  2);
                       }
        }
        break;
      case MULTIPLY:
        jj_consume_token(MULTIPLY);
                          SimpleNode jjtn003 = new SimpleNode(JJTMUL);
                          boolean jjtc003 = true;
                          jjtree.openNodeScope(jjtn003);
        try {
          Priority4(sign);
        } catch (Throwable jjte003) {
                          if (jjtc003) {
                            jjtree.clearNodeScope(jjtn003);
                            jjtc003 = false;
                          } else {
                            jjtree.popNode();
                          }
                          if (jjte003 instanceof RuntimeException) {
                            {if (true) throw (RuntimeException)jjte003;}
                          }
                          if (jjte003 instanceof ParseException) {
                            {if (true) throw (ParseException)jjte003;}
                          }
                          {if (true) throw (Error)jjte003;}
        } finally {
                          if (jjtc003) {
                            jjtree.closeNodeScope(jjtn003,  2);
                          }
        }
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[10] = jj_gen;
      ;
    }
  }

  static final public void Priority4(int sign) throws ParseException {
                                 Token i;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PARENTHESIS_LEFT:
      jj_consume_token(PARENTHESIS_LEFT);
      Priority1(sign);
      jj_consume_token(PARENTHESIS_RIGHT);
      break;
    case SYMBOL:
      i = jj_consume_token(SYMBOL);
   SimpleNode jjtn001 = new SimpleNode(JJTMATRIX);
   boolean jjtc001 = true;
   jjtree.openNodeScope(jjtn001);
      try {
   jjtree.closeNodeScope(jjtn001, true);
   jjtc001 = false;
   jjtn001.jjtSetValue( i.image);
      } finally {
   if (jjtc001) {
     jjtree.closeNodeScope(jjtn001, true);
   }
      }
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public MatrixTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[12];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x4000,0x8000,0x800000,0x800000,0x11000,0x30,0x30,0x40,0x80,0x70,0x70,0x11000,};
   }

  /** Constructor with InputStream. */
  public Matrix(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Matrix(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MatrixTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Matrix(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new MatrixTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Matrix(MatrixTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(MatrixTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[24];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 12; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 24; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
