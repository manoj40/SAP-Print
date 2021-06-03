package com.carrefour.printer.printerapp;

//import java.util.Vector;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
//import java.lang.*;
//import java.net.*;
//import java.io.*;
//import java.time.*;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class ObjetoDEVICE {

  private static final String PADEST = ""; // ---PADEST empty, so that SAP assigns it automatically

  private static final char PACLASS = '0'; // ---Not used

  private static final char PAARCHIVER = '0'; // ---Not used

  private static final char PALANGU = '0'; // ---Not used

  private static final char PADISABLED = '0'; // ---Not used

  private static final char PANOQUERY = '0'; // ---Not used

  private static final char PADUPCOPY = 'X';

  private static final char PADUPLEX = '0'; // ---Not used

  private static final char PASTORELOC = '0'; // ---Not used

  private static final char PADFLTUTTL = '0'; // ---Not used

  private static final char PADFLTSTTL = '0'; // ---Not used

  private static final char PASYNC = '0'; // NULL, do not confuse with '0'!!

  private static final char PAMONI = '0'; // ---Not used

  private static final char PAMETHOD = 'U'; // Print method = 'U'

  private static final String PALOMS = ""; // ---Not used

  private static final char PALPRCMD = '0'; // ---Not used

  private static final String PALPDPORT = "0"; // Default TCP port = "0"; alternative for spool host SAPSprint "512"...

  private static final String PACONNTIME = "0";

  private static final String PAREADTIME = "0";

  private static final String PATRAYS = "0";

  private static final String PAXSHIFT = "0";

  private static final String PAYSHIFT = "0";

  private static final String PAXSHUNIT = "MM";

  private static final String PAYSHUNIT = "MM";

  private static final char PACRYPTMOD = '0'; // NULL, do not confuse with '0'!!

  private static final char PACRYPTMET = '0'; // NULL, do not confuse with '0'!!

  private static final char PANOVSERVR = '0'; // NULL, do not confuse with '0'!!

  private static final char PAPOOLART = 'P';

  private static final char PATRACE2 = '0'; // NULL, do not confuse with '0'!!

  private static final char PATRACEF = '0'; // NULL, do not confuse with '0'!!

  private static final char PAPROTDATA = '0'; // NULL, do not confuse with '0'!!

  private static final char PAPROTCMD = '0'; // NULL, do not confuse with '0'!!

  private static final char PAPROTRES = '0'; // NULL, do not confuse with '0'!!

  private static final char PAKEEPFILE = '0'; // NULL, do not confuse with '0'!!

  private static final String CHGSAPREL1 = "752";

  private static final String PADEVGRP = "";

  private static final char PRINTMODE = '0'; // NULL, do not confuse with '0'!!

  private static final String INPUTTRAY = "";

  private static final char PANOCHOICE = '0'; // NULL, do not confuse with '0'!!

  // Nombre excel column D
  // ES1625S51 - Tienda
  private String name; // NAME = "ES1625S51B3 - Tienda"

  private String padest; // Not found in excel

  private String patype; // Device Type ZHPLJCM1 Column F

  private String pamodel; // Modelo Column C

  private char paclass; // Empty

  private char paarchiver;// Empty

  private char palangu;// Empty

  private char padisabled;// Empty

  private char panoquery;// Empty

  private char padupcopy; // allways "X"

  private char paduplex; // Empty

  private char pastoreloc;// Empty

  private char padfltuttl;// Empty

  private char padfltsttl;// Empty

  private char pasync;// Empty

  private char pamoni;// Empty

  private String pastandort; // Localización Column K

  private String pamsg; // Comentarios SPAD Column L

  private String pamsserver; // Not found in excel

  private char pamethod; // Método de Acceso Column G allways "U"

  private String paprosname;// Column E

  private String paloms;// Empty

  private char palprcmd;// Empty

  private String palpdhost;// Column E

  private String palpdport; // "0"

  private String paconntime;// "0"

  private String pareadtime;// "0"

  private String patrays;// "0"

  private String paxshift;// "0"

  private String payshift;// "0"

  private String paxshunit; // Not found in excel

  private String payshunit;// Not found in excel

  private char pacryptmod;// Empty

  private char pacryptmet;// Empty

  private char panovservr;// Empty

  private char papoolart; // Not found in excel

  private char patrace2; // Empty

  private char patracef; // Empty

  private char paprotdata;// Empty

  private char paprotcmd;// Empty

  private char paprotres;// Empty

  private char pakeepfile;// Empty

  private String chgname1;// Not found in excel

  private String chgtstmp1;// Not found

  private String chgsaprel1; // Not found

  private String chgsapsys1; // Not clear is it column A

  private String padevgrp;// Empty

  private char colorprt; // Empty or "X"

  private char printmode; // Empty

  private String inputtray; // Empty

  private char panochoice; // Empty

  private ObjetoATTR[] attr;

  private ObjetoPOCCNF[] poccnf;

  // <E> Set<E> java.util.Set.of(E e1)
  /*
   * private static <String> Set<String> Patype of("HPLJCM1", "LXMS410", "LXMS811", "LXT650", "LXT654", "RC000118",
   * "RC001118", "RC001U18", "ZLXMS410");
   */

  // Constructor methods
  // -------------------
  public ObjetoDEVICE(String name, String padest, String patype, String pamodel, char paclass, char paarchiver,
      char palangu, char padisabled, char panoquery, char padupcopy, char paduplex, char pastoreloc, char padfltuttl,
      char padfltsttl, char pasync, char pamoni, String pastandort, String pamsg, String pamsserver, char pamethod,
      String paprosname, String paloms, char palprcmd, String palpdhost, String palpdport, String paconntime,
      String pareadtime, String patrays, String paxshift, String payshift, String paxshunit, String payshunit,
      char pacryptmod, char pacryptmet, char panovservr, char papoolart, char patrace2, char patracef, char paprotdata,
      char paprotcmd, char paprotres, char pakeepfile, String chgname1, String chgsaprel1, String chgsapsys1,
      String padevgrp, char colorprt, char printmode, String inputtray, char panochoice) {

    if (!name.isEmpty()) {
      this.name = name;
    }
    this.padest = padest;
    this.patype = patype;
    this.pamodel = pamodel;
    this.paclass = paclass;
    this.paarchiver = paarchiver;
    this.palangu = palangu;
    this.padisabled = padisabled;
    this.panoquery = panoquery;
    this.padupcopy = padupcopy;
    this.paduplex = paduplex;
    this.pastoreloc = pastoreloc;
    this.padfltuttl = padfltuttl;
    this.padfltsttl = padfltsttl;
    this.pasync = pasync;
    this.pamoni = pamoni;
    this.pastandort = pastandort;
    this.pamsg = pamsg;
    this.pamsserver = pamsserver;
    this.pamethod = pamethod;
    this.paprosname = paprosname;
    this.paloms = paloms;
    this.palprcmd = palprcmd;
    this.palpdhost = palpdhost;
    this.palpdport = palpdport;
    this.paconntime = paconntime;
    this.pareadtime = pareadtime;
    this.patrays = patrays;
    this.paxshift = paxshift;
    this.payshift = payshift;
    this.paxshunit = paxshunit;
    this.payshunit = payshunit;
    this.pacryptmod = pacryptmod;
    this.pacryptmet = pacryptmet;
    this.panovservr = panovservr;
    this.papoolart = papoolart;
    this.patrace2 = patrace2;
    this.patracef = patracef;
    this.paprotdata = paprotdata;
    this.paprotcmd = paprotcmd;
    this.paprotres = paprotres;
    this.pakeepfile = pakeepfile;
    this.chgname1 = chgname1;

    Date fechaDate = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
    this.chgtstmp1 = dateFormat.format(fechaDate);

    this.chgsaprel1 = chgsaprel1;
    this.chgsapsys1 = chgsapsys1;
    this.padevgrp = padevgrp;
    this.colorprt = colorprt;
    this.printmode = printmode;
    this.inputtray = inputtray;
    this.panochoice = panochoice;
  }

  public ObjetoDEVICE(String name, String padest, String patype, String pamodel, char padupcopy, String pastandort,
      String pamsg, String pamsserver, char pamethod, String paprosname, String palpdhost, String palpdport,
      String chgname1, String chgsaprel1, String chgsapsys1, String padevgrp, char colorprt) {

    this(name, padest, patype, pamodel, PACLASS, PAARCHIVER, PALANGU, PADISABLED, PANOQUERY, padupcopy, PADUPLEX,
        PASTORELOC, PADFLTUTTL, PADFLTSTTL, PASYNC, PAMONI, pastandort, pamsg, pamsserver, pamethod, paprosname, PALOMS,
        PALPRCMD, palpdhost, palpdport, PACONNTIME, PAREADTIME, PATRAYS, PAXSHIFT, PAYSHIFT, PAXSHUNIT, PAYSHUNIT,
        PACRYPTMOD, PACRYPTMET, PANOVSERVR, PAPOOLART, PATRACE2, PATRACEF, PAPROTDATA, PAPROTCMD, PAPROTRES, PAKEEPFILE,
        chgname1, chgsaprel1, chgsapsys1, padevgrp, colorprt, PRINTMODE, INPUTTRAY, PANOCHOICE);

  }

  public ObjetoDEVICE(String name, String padest, String patype, String pamodel, String pastandort, String pamsg,
      String pamsserver, char pamethod, String paprosname, String palpdhost, String palpdport, String chgname1,
      String chgsapsys1, String padevgrp, char colorprt) {

    this(name, padest, patype, pamodel, PADUPCOPY, pastandort, pamsg, pamsserver, pamethod, paprosname, palpdhost,
        palpdport, chgname1, CHGSAPREL1, chgsapsys1, padevgrp, colorprt);

  }

  public ObjetoDEVICE(String name, String patype, String pamodel, String pastandort, String pamsg, String pamsserver,
      String paprosname, String palpdhost, String palpdport, String chgname1, String chgsapsys1, char colorprt) {

    this(name, PADEST, patype, pamodel, pastandort, pamsg, pamsserver, PAMETHOD, paprosname, palpdhost, PALPDPORT,
        chgname1, chgsapsys1, PADEVGRP, colorprt);

  }

  // Methods to assign values of fields
  // ----------------------------------

  // Methods to check values of fields
  // ---------------------------------
  public String getName() {

    return this.name;
  }

  public String getPadest() {

    return this.padest;
  }

  public String getPatype() {

    return this.patype;
  }

  public String getPamodel() {

    return this.pamodel;
  }

  public char getPaclass() {

    return this.paclass;
  }

  public char getPaarchiver() {

    return this.paarchiver;
  }

  public char getPalangu() {

    return this.palangu;
  }

  public char getPadisabled() {

    return this.padisabled;
  }

  public char getPanoquery() {

    return this.panoquery;
  }

  public char getPadupcopy() {

    return this.padupcopy;
  }

  public char getPaduplex() {

    return this.paduplex;
  }

  public char getPastoreloc() {

    return this.pastoreloc;
  }

  public char getPadfltuttl() {

    return this.padfltuttl;
  }

  public char getPadfltsttl() {

    return this.padfltsttl;
  }

  public char getPasync() {

    return this.pasync;
  }

  public char getPamoni() {

    return this.pamoni;
  }

  public String getPastandort() {

    return this.pastandort;
  }

  public String getPamsg() {

    return this.pamsg;
  }

  public String getPamsserver() {

    return this.pamsserver;
  }

  public char getPamethod() {

    return this.pamethod;
  }

  public String getPaprosname() {

    return this.paprosname;
  }

  public String getPaloms() {

    return this.paloms;
  }

  public char getPalprcmd() {

    return this.palprcmd;
  }

  public String getPalpdhost() {

    return this.palpdhost;
  }

  public String getPalpdport() {

    return this.palpdport;
  }

  public String getPaconntime() {

    return this.paconntime;
  }

  public String getPareadtime() {

    return this.pareadtime;
  }

  public String getPatrays() {

    return this.patrays;
  }

  public String getPaxshift() {

    return this.paxshift;
  }

  public String getPayshift() {

    return this.payshift;
  }

  public String getPaxshunit() {

    return this.paxshunit;
  }

  public String getPayshunit() {

    return this.payshunit;
  }

  public char getPacryptmod() {

    return this.pacryptmod;
  }

  public char getPacryptmet() {

    return this.pacryptmet;
  }

  public char getPanovservr() {

    return this.panovservr;
  }

  public char getPapoolart() {

    return this.papoolart;
  }

  public char getPatrace2() {

    return this.patrace2;
  }

  public char getPatracef() {

    return this.patracef;
  }

  public char getPaprotdata() {

    return this.paprotdata;
  }

  public char getPaprotcmd() {

    return this.paprotcmd;
  }

  public char getPaprotres() {

    return this.paprotres;
  }

  public char getPakeepfile() {

    return this.pakeepfile;
  }

  public String getChgname1() {

    return this.chgname1;
  }

  public String getChgtstmp1() {

    return this.chgtstmp1;
  }

  public String getChgsaprel1() {

    return this.chgsaprel1;
  }

  public String getChgsapsys1() {

    return this.chgsapsys1;
  }

  public String getPadevgrp() {

    return this.padevgrp;
  }

  public char getColorprt() {

    return this.colorprt;
  }

  public char getPrintmode() {

    return this.printmode;
  }

  public String getInputtray() {

    return this.inputtray;
  }

  public char getPanochoice() {

    return this.panochoice;
  }

  public ObjetoATTR getAttr(int index) {

    return this.attr[index];
  }

  public ObjetoPOCCNF getPoccnf(int index) {

    return this.poccnf[index];
  }

  // ===============================================================================
  /**
   * @return attr
   */
  public ObjetoATTR[] getAttr() {

    return this.attr;
  }

  /**
   * @param attr new value of {@link #getattr}.
   */
  public void setAttr(ObjetoATTR[] attr) {

    this.attr = attr;
  }

  /**
   * @return poccnf
   */
  public ObjetoPOCCNF[] getPoccnf() {

    return this.poccnf;
  }

  /**
   * @param poccnf new value of {@link #getpoccnf}.
   */
  public void setPoccnf(ObjetoPOCCNF[] poccnf) {

    this.poccnf = poccnf;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  public void setName(String name) {

    if (StringUtils.isNotBlank(name)) {
      this.name = name;
    } else {
      this.name = "";
    }
  }

  /**
   * @param padest new value of {@link #getpadest}.
   */
  public void setPadest(String padest) {

    this.padest = padest;
  }

  /**
   * @param patype new value of {@link #getpatype}.
   */
  public void setPatype(String patype) {

    this.patype = patype;
  }

  /**
   * @param pamodel new value of {@link #getpamodel}.
   */
  public void setPamodel(String pamodel) {

    this.pamodel = pamodel;
  }

  /**
   * @param paclass new value of {@link #getpaclass}.
   */
  public void setPaclass(char paclass) {

    this.paclass = paclass;
  }

  /**
   * @param paarchiver new value of {@link #getpaarchiver}.
   */
  public void setPaarchiver(char paarchiver) {

    this.paarchiver = paarchiver;
  }

  /**
   * @param palangu new value of {@link #getpalangu}.
   */
  public void setPalangu(char palangu) {

    this.palangu = palangu;
  }

  /**
   * @param padisabled new value of {@link #getpadisabled}.
   */
  public void setPadisabled(char padisabled) {

    this.padisabled = padisabled;
  }

  /**
   * @param panoquery new value of {@link #getpanoquery}.
   */
  public void setPanoquery(char panoquery) {

    this.panoquery = panoquery;
  }

  /**
   * @param padupcopy new value of {@link #getpadupcopy}.
   */
  public void setPadupcopy(char padupcopy) {

    this.padupcopy = padupcopy;
  }

  /**
   * @param paduplex new value of {@link #getpaduplex}.
   */
  public void setPaduplex(char paduplex) {

    this.paduplex = paduplex;
  }

  /**
   * @param pastoreloc new value of {@link #getpastoreloc}.
   */
  public void setPastoreloc(char pastoreloc) {

    this.pastoreloc = pastoreloc;
  }

  /**
   * @param padfltuttl new value of {@link #getpadfltuttl}.
   */
  public void setPadfltuttl(char padfltuttl) {

    this.padfltuttl = padfltuttl;
  }

  /**
   * @param padfltsttl new value of {@link #getpadfltsttl}.
   */
  public void setPadfltsttl(char padfltsttl) {

    this.padfltsttl = padfltsttl;
  }

  /**
   * @param pasync new value of {@link #getpasync}.
   */
  public void setPasync(char pasync) {

    this.pasync = pasync;
  }

  /**
   * @param pamoni new value of {@link #getpamoni}.
   */
  public void setPamoni(char pamoni) {

    this.pamoni = pamoni;
  }

  /**
   * @param pastandort new value of {@link #getpastandort}.
   */
  public void setPastandort(String pastandort) {

    this.pastandort = pastandort;
  }

  /**
   * @param pamsg new value of {@link #getpamsg}.
   */
  public void setPamsg(String pamsg) {

    this.pamsg = pamsg;
  }

  /**
   * @param pamsserver new value of {@link #getpamsserver}.
   */
  public void setPamsserver(String pamsserver) {

    this.pamsserver = pamsserver;
  }

  /**
   * @param pamethod new value of {@link #getpamethod}.
   */
  public void setPamethod(char pamethod) {

    this.pamethod = pamethod;
  }

  /**
   * @param paprosname new value of {@link #getpaprosname}.
   */
  public void setPaprosname(String paprosname) {

    this.paprosname = paprosname;
  }

  /**
   * @param paloms new value of {@link #getpaloms}.
   */
  public void setPaloms(String paloms) {

    this.paloms = paloms;
  }

  /**
   * @param palprcmd new value of {@link #getpalprcmd}.
   */
  public void setPalprcmd(char palprcmd) {

    this.palprcmd = palprcmd;
  }

  /**
   * @param palpdhost new value of {@link #getpalpdhost}.
   */
  public void setPalpdhost(String palpdhost) {

    this.palpdhost = palpdhost;
  }

  /**
   * @param palpdport new value of {@link #getpalpdport}.
   */
  public void setPalpdport(String palpdport) {

    this.palpdport = palpdport;
  }

  /**
   * @param paconntime new value of {@link #getpaconntime}.
   */
  public void setPaconntime(String paconntime) {

    this.paconntime = paconntime;
  }

  /**
   * @param pareadtime new value of {@link #getpareadtime}.
   */
  public void setPareadtime(String pareadtime) {

    this.pareadtime = pareadtime;
  }

  /**
   * @param patrays new value of {@link #getpatrays}.
   */
  public void setPatrays(String patrays) {

    this.patrays = patrays;
  }

  /**
   * @param paxshift new value of {@link #getpaxshift}.
   */
  public void setPaxshift(String paxshift) {

    this.paxshift = paxshift;
  }

  /**
   * @param payshift new value of {@link #getpayshift}.
   */
  public void setPayshift(String payshift) {

    this.payshift = payshift;
  }

  /**
   * @param paxshunit new value of {@link #getpaxshunit}.
   */
  public void setPaxshunit(String paxshunit) {

    this.paxshunit = paxshunit;
  }

  /**
   * @param payshunit new value of {@link #getpayshunit}.
   */
  public void setPayshunit(String payshunit) {

    this.payshunit = payshunit;
  }

  /**
   * @param pacryptmod new value of {@link #getpacryptmod}.
   */
  public void setPacryptmod(char pacryptmod) {

    this.pacryptmod = pacryptmod;
  }

  /**
   * @param pacryptmet new value of {@link #getpacryptmet}.
   */
  public void setPacryptmet(char pacryptmet) {

    this.pacryptmet = pacryptmet;
  }

  /**
   * @param panovservr new value of {@link #getpanovservr}.
   */
  public void setPanovservr(char panovservr) {

    this.panovservr = panovservr;
  }

  /**
   * @param papoolart new value of {@link #getpapoolart}.
   */
  public void setPapoolart(char papoolart) {

    this.papoolart = papoolart;
  }

  /**
   * @param patrace2 new value of {@link #getpatrace2}.
   */
  public void setPatrace2(char patrace2) {

    this.patrace2 = patrace2;
  }

  /**
   * @param patracef new value of {@link #getpatracef}.
   */
  public void setPatracef(char patracef) {

    this.patracef = patracef;
  }

  /**
   * @param paprotdata new value of {@link #getpaprotdata}.
   */
  public void setPaprotdata(char paprotdata) {

    this.paprotdata = paprotdata;
  }

  /**
   * @param paprotcmd new value of {@link #getpaprotcmd}.
   */
  public void setPaprotcmd(char paprotcmd) {

    this.paprotcmd = paprotcmd;
  }

  /**
   * @param paprotres new value of {@link #getpaprotres}.
   */
  public void setPaprotres(char paprotres) {

    this.paprotres = paprotres;
  }

  /**
   * @param pakeepfile new value of {@link #getpakeepfile}.
   */
  public void setPakeepfile(char pakeepfile) {

    this.pakeepfile = pakeepfile;
  }

  /**
   * @param chgname1 new value of {@link #getchgname1}.
   */
  public void setChgname1(String chgname1) {

    this.chgname1 = chgname1;
  }

  /**
   * @param chgtstmp1 new value of {@link #getchgtstmp1}.
   */
  public void setChgtstmp1(String chgtstmp1) {

    this.chgtstmp1 = chgtstmp1;
  }

  /**
   * @param chgsaprel1 new value of {@link #getchgsaprel1}.
   */
  public void setChgsaprel1(String chgsaprel1) {

    this.chgsaprel1 = chgsaprel1;
  }

  /**
   * @param chgsapsys1 new value of {@link #getchgsapsys1}.
   */
  public void setChgsapsys1(String chgsapsys1) {

    this.chgsapsys1 = chgsapsys1;
  }

  /**
   * @param padevgrp new value of {@link #getpadevgrp}.
   */
  public void setPadevgrp(String padevgrp) {

    this.padevgrp = padevgrp;
  }

  /**
   * @param colorprt new value of {@link #getcolorprt}.
   */
  public void setColorprt(char colorprt) {

    this.colorprt = colorprt;
  }

  /**
   * @param printmode new value of {@link #getprintmode}.
   */
  public void setPrintmode(char printmode) {

    this.printmode = printmode;
  }

  /**
   * @param inputtray new value of {@link #getinputtray}.
   */
  public void setInputtray(String inputtray) {

    this.inputtray = inputtray;
  }

  /**
   * @param panochoice new value of {@link #getpanochoice}.
   */
  public void setPanochoice(char panochoice) {

    this.panochoice = panochoice;
  }

  @Override
  public String toString() {

    return "ObjetoDEVICE [name=" + this.name + ", padest=" + this.padest + ", patype=" + this.patype + ", pamodel="
        + this.pamodel + ", paclass=" + this.paclass + ", paarchiver=" + this.paarchiver + ", palangu=" + this.palangu
        + ", padisabled=" + this.padisabled + ", panoquery=" + this.panoquery + ", padupcopy=" + this.padupcopy
        + ", paduplex=" + this.paduplex + ", pastoreloc=" + this.pastoreloc + ", padfltuttl=" + this.padfltuttl
        + ", padfltsttl=" + this.padfltsttl + ", pasync=" + this.pasync + ", pamoni=" + this.pamoni + ", pastandort="
        + this.pastandort + ", pamsg=" + this.pamsg + ", pamsserver=" + this.pamsserver + ", pamethod=" + this.pamethod
        + ", paprosname=" + this.paprosname + ", paloms=" + this.paloms + ", palprcmd=" + this.palprcmd + ", palpdhost="
        + this.palpdhost + ", palpdport=" + this.palpdport + ", paconntime=" + this.paconntime + ", pareadtime="
        + this.pareadtime + ", patrays=" + this.patrays + ", paxshift=" + this.paxshift + ", payshift=" + this.payshift
        + ", paxshunit=" + this.paxshunit + ", payshunit=" + this.payshunit + ", pacryptmod=" + this.pacryptmod
        + ", pacryptmet=" + this.pacryptmet + ", panovservr=" + this.panovservr + ", papoolart=" + this.papoolart
        + ", patrace2=" + this.patrace2 + ", patracef=" + this.patracef + ", paprotdata=" + this.paprotdata
        + ", paprotcmd=" + this.paprotcmd + ", paprotres=" + this.paprotres + ", pakeepfile=" + this.pakeepfile
        + ", chgname1=" + this.chgname1 + ", chgtstmp1=" + this.chgtstmp1 + ", chgsaprel1=" + this.chgsaprel1
        + ", chgsapsys1=" + this.chgsapsys1 + ", padevgrp=" + this.padevgrp + ", colorprt=" + this.colorprt
        + ", printmode=" + this.printmode + ", inputtray=" + this.inputtray + ", panochoice=" + this.panochoice
        + ", attr=" + Arrays.toString(this.attr) + ", poccnf=" + Arrays.toString(this.poccnf) + "]";
  }

}
