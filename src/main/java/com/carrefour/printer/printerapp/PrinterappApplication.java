package com.carrefour.printer.printerapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * TODO madwived This type ...
 *
 */
public class PrinterappApplication {

  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {

    // ClassLoader classLoader = PrinterappApplication.class.getClassLoader();
    String excelFilePath = args[0];
    System.out.println(" Input File : " + excelFilePath);
    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
    Workbook workbook = new XSSFWorkbook(inputStream);
    System.out.println(" Configuration File : " + args[1]);
    String excelFilePathPoccnf = args[1];
    FileInputStream inputStreamPoccnf = new FileInputStream(new File(excelFilePathPoccnf));
    Workbook workbookPoccnf = new XSSFWorkbook(inputStreamPoccnf);

    System.out.println(" Output File A4P: " + args[2]);
    System.out.println(" Output File ACP: " + args[3]);
    FileWriter a4pWriter = new FileWriter(args[2]);// "C:\\Devonfw\\Test\\A4P2.txt"
    FileWriter acpWriter = new FileWriter(args[3]);// "C:\\Devonfw\\Test\\ACP2.txt"
    Date fechaDate = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
    String fechaString = dateFormat.format(fechaDate);
    a4pWriter.write("VERSION = \"0.1\"");
    a4pWriter.write("\nTIME = \"" + fechaString + "\"");
    a4pWriter.write("\nSYSTEM = \"A4P\"");
    a4pWriter.write("\nRELEASE = \"752\"\n");

    acpWriter.write("VERSION = \"0.1\"");
    acpWriter.write("\nTIME = \"" + fechaString + "\"");
    acpWriter.write("\nSYSTEM = \"ACP\"");
    acpWriter.write("\nRELEASE = \"752\"\n");

    Sheet sheet = workbook.getSheetAt(0);
    Iterator iterator = sheet.iterator();

    while (iterator.hasNext()) {
      Row nextRow = (Row) iterator.next();
      Iterator cellIterator = nextRow.cellIterator();
      if (nextRow.getRowNum() == 0)
        continue;

      String chgsapsys1 = ""; // column A (Sistema) 1
      String name = "";// , column B (Nombre) 2
      String paprosname = "";// , Column C IP 3
      String palpdhost = "";// , Column C IP 3
      String patype = "";// , Column D Device Type 4
      String pamodel = "";// , Column E Modelo 5
      char colorprt = 'X';// , Empty or "X" need to clear Column F Tipo 6
      String tray = ""; // Column H Print options 8
      String printTicket = "";// Print Tickets Column I 9
      String pastandort = ""; // Column J Ubicación 10
      String pamsg = "";// , Column K Comentarios 11
      String pamsserver = "Z_SPOOL";// , need to clear
      String palpdport = "";// , allways 0
      String chgname1 = "ADMIN";// , need to clear

      while (cellIterator.hasNext()) {
        Cell cell = (Cell) cellIterator.next();
        int columnIndex = cell.getColumnIndex();
        switch (columnIndex + 1) {
          case 1:
            chgsapsys1 = cell.getStringCellValue();
            break;
          case 2:
            name = cell.getStringCellValue();
            break;
          case 3:
            paprosname = cell.getStringCellValue();
            palpdhost = cell.getStringCellValue();
            break;
          case 4:
            patype = cell.getStringCellValue();
            break;
          case 5:
            pamodel = cell.getStringCellValue();
            break;
          case 6:
            if (StringUtils.isNotBlank(cell.getStringCellValue())
                && cell.getStringCellValue().equalsIgnoreCase("Color")) {
              colorprt = 'X';
            } else {
              colorprt = '0';
            }
            break;
          case 8:
            tray = cell.getStringCellValue();
            break;
          case 9:
            printTicket = cell.getStringCellValue();
            break;
          case 10:
            pastandort = cell.getStringCellValue();
            break;
          case 11:
            pamsg = cell.getStringCellValue();
            break;
        }
      }
      ObjetoDEVICE device = new ObjetoDEVICE(name, patype, pamodel, pastandort, pamsg, pamsserver, paprosname,
          palpdhost, palpdport, chgname1, chgsapsys1, colorprt);
      if (chgsapsys1.equals("A4P")) {
        writeToFile(a4pWriter, device, tray, printTicket, workbook, workbookPoccnf);
      }
      if (chgsapsys1.equals("ACP")) {
        writeToFile(acpWriter, device, tray, printTicket, workbook, workbookPoccnf);
      }
    }
    workbook.close();
    inputStream.close();
    a4pWriter.close();
    acpWriter.close();
  }

  /**
   * @param myWriter
   * @throws IOException
   *
   */
  private static void writeToFile(FileWriter myWriter, ObjetoDEVICE device, String tray, String printTicket,
      Workbook workbook, Workbook workbookPoccnf) throws IOException {

    myWriter.write("* DEVICE = {");
    myWriter.write("\n  NAME = " + "\"" + (StringUtils.isNotBlank(device.getName()) ? device.getName() : "") + "\"");
    myWriter
        .write("\n  PADEST = " + "\"" + (StringUtils.isNotBlank(device.getPadest()) ? device.getPadest() : "") + "\"");
    myWriter
        .write("\n  PATYPE = " + "\"" + (StringUtils.isNotBlank(device.getPatype()) ? device.getPatype() : "") + "\"");
    myWriter.write(
        "\n  PAMODEL = " + "\"" + (StringUtils.isNotBlank(device.getPamodel()) ? device.getPamodel() : "") + "\"");
    myWriter.write("\n  PACLASS = " + "\"" + (device.getPaclass() == '0' ? "" : device.getPaclass()) + "\"");
    myWriter.write("\n  PAARCHIVER = " + "\"" + (device.getPaarchiver() == '0' ? "" : device.getPaarchiver()) + "\"");
    myWriter.write("\n  PALANGU = " + "\"" + (device.getPalangu() == '0' ? "" : device.getPalangu()) + "\"");
    myWriter.write("\n  PADISABLED = " + "\"" + (device.getPadisabled() == '0' ? "" : device.getPadisabled()) + "\"");
    myWriter.write("\n  PANOQUERY = " + "\"" + (device.getPanoquery() == '0' ? "" : device.getPanoquery()) + "\"");
    myWriter.write("\n  PADUPCOPY = " + "\"" + (device.getPadupcopy() == 'X' ? "X" : device.getPadupcopy()) + "\"");
    myWriter.write("\n  PADUPLEX = " + "\"" + (device.getPaduplex() == '0' ? "" : device.getPaduplex()) + "\"");
    myWriter.write("\n  PASTORELOC = " + "\"" + (device.getPastoreloc() == '0' ? "" : device.getPastoreloc()) + "\"");
    myWriter.write("\n  PADFLTUTTL = " + "\"" + (device.getPadfltuttl() == '0' ? "" : device.getPadfltuttl()) + "\"");
    myWriter.write("\n  PADFLTSTTL = " + "\"" + (device.getPadfltsttl() == '0' ? "" : device.getPadfltsttl()) + "\"");
    myWriter.write("\n  PASYNC = " + "\"" + (device.getPasync() == '0' ? "" : device.getPasync()) + "\"");
    myWriter.write("\n  PAMONI = " + "\"" + (device.getPamoni() == '0' ? "" : device.getPamoni()) + "\"");
    myWriter.write("\n  PASTANDORT = " + "\""
        + (StringUtils.isNotBlank(device.getPastandort()) ? device.getPastandort() : "") + "\"");
    myWriter.write("\n  PAMSG = " + "\"" + (StringUtils.isNotBlank(device.getPamsg()) ? device.getPamsg() : "") + "\"");
    myWriter.write("\n  PAMSSERVER = " + "\""
        + (StringUtils.isNotBlank(device.getPamsserver()) ? device.getPamsserver() : "") + "\"");
    myWriter.write("\n  PAMETHOD = " + "\"" + (device.getPamethod() == 'U' ? "U" : device.getPamethod()) + "\"");

    myWriter.write("\n  PAPROSNAME = " + "\""
        + (StringUtils.isNotBlank(device.getPaprosname()) ? device.getPaprosname() : "") + "\"");
    myWriter
        .write("\n  PALOMS = " + "\"" + (StringUtils.isNotBlank(device.getPaloms()) ? device.getPaloms() : "") + "\"");
    myWriter.write("\n  PALPRCMD = " + "\"" + (device.getPalprcmd() == '0' ? "" : device.getPalprcmd()) + "\"");
    myWriter.write("\n  PALPDHOST = " + "\""
        + (StringUtils.isNotBlank(device.getPalpdhost()) ? device.getPalpdhost() : "") + "\"");
    myWriter.write("\n  PALPDPORT = " + "\""
        + (StringUtils.isNotBlank(device.getPalpdport()) ? device.getPalpdport() : "") + "\"");
    myWriter.write("\n  PACONNTIME = " + "\""
        + (StringUtils.isNotBlank(device.getPaconntime()) ? device.getPaconntime() : "") + "\"");
    myWriter.write("\n  PAREADTIME = " + "\""
        + (StringUtils.isNotBlank(device.getPareadtime()) ? device.getPareadtime() : "") + "\"");
    myWriter.write(
        "\n  PATRAYS = " + "\"" + (StringUtils.isNotBlank(device.getPatrays()) ? device.getPatrays() : "") + "\"");
    myWriter.write(
        "\n  PAXSHIFT = " + "\"" + (StringUtils.isNotBlank(device.getPaxshift()) ? device.getPaxshift() : "") + "\"");
    myWriter.write(
        "\n  PAYSHIFT = " + "\"" + (StringUtils.isNotBlank(device.getPayshift()) ? device.getPayshift() : "") + "\"");
    myWriter.write("\n  PAXSHUNIT = " + "\""
        + (StringUtils.isNotBlank(device.getPaxshunit()) ? device.getPaxshunit() : "") + "\"");
    myWriter.write("\n  PAYSHUNIT = " + "\""
        + (StringUtils.isNotBlank(device.getPayshunit()) ? device.getPayshunit() : "") + "\"");
    myWriter.write("\n  PACRYPTMOD = " + "\"" + (device.getPacryptmod() == '0' ? "" : device.getPacryptmod()) + "\"");
    myWriter.write("\n  PACRYPTMET = " + "\"" + (device.getPacryptmet() == '0' ? "" : device.getPacryptmet()) + "\"");
    myWriter.write("\n  PANOVSERVR = " + "\"" + (device.getPanovservr() == '0' ? "" : device.getPanovservr()) + "\"");
    myWriter.write("\n  PAPOOLART = " + "\"" + (device.getPapoolart() == '0' ? "" : device.getPapoolart()) + "\"");
    myWriter.write("\n  PATRACE2 = " + "\"" + (device.getPatrace2() == '0' ? "" : device.getPatrace2()) + "\"");
    myWriter.write("\n  PATRACEF = " + "\"" + (device.getPatracef() == '0' ? "" : device.getPatracef()) + "\"");
    myWriter.write("\n  PAPROTDATA = " + "\"" + (device.getPaprotdata() == '0' ? "" : device.getPaprotdata()) + "\"");
    myWriter.write("\n  PAPROTCMD = " + "\"" + (device.getPaprotcmd() == '0' ? "" : device.getPaprotcmd()) + "\"");
    myWriter.write("\n  PAPROTRES = " + "\"" + (device.getPaprotres() == '0' ? "" : device.getPaprotres()) + "\"");
    myWriter.write("\n  PAKEEPFILE = " + "\"" + (device.getPakeepfile() == '0' ? "" : device.getPakeepfile()) + "\"");
    myWriter.write(
        "\n  CHGNAME1 = " + "\"" + (StringUtils.isNotBlank(device.getChgname1()) ? device.getChgname1() : "") + "\"");
    myWriter.write("\n  CHGTSTMP1 = " + "\""
        + (StringUtils.isNotBlank(device.getChgtstmp1()) ? device.getChgtstmp1() : "") + "\"");
    myWriter.write("\n  CHGSAPREL1 = " + "\""
        + (StringUtils.isNotBlank(device.getChgsaprel1()) ? device.getChgsaprel1() : "") + "\"");
    myWriter.write("\n  CHGSAPSYS1 = " + "\""
        + (StringUtils.isNotBlank(device.getChgsapsys1()) ? device.getChgsapsys1() : "") + "\"");
    myWriter.write(
        "\n  PADEVGRP = " + "\"" + (StringUtils.isNotBlank(device.getPadevgrp()) ? device.getPadevgrp() : "") + "\"");
    myWriter.write("\n  COLORPRT = " + "\"" + (device.getColorprt() == '0' ? "" : device.getColorprt()) + "\"");
    myWriter.write("\n  PRINTMODE = " + "\"" + (device.getPrintmode() == '0' ? "" : device.getPrintmode()) + "\"");
    myWriter.write("\n  INPUTTRAY = " + "\""
        + (StringUtils.isNotBlank(device.getInputtray()) ? device.getInputtray() : "") + "\"");
    myWriter.write("\n  PANOCHOICE = " + "\"" + (device.getPanochoice() == '0' ? "" : device.getPanochoice()) + "\"");

    if (StringUtils.isNotBlank(tray) && !tray.equalsIgnoreCase("n/a") && !tray.contains("1")
        && StringUtils.isNotBlank(printTicket) && !printTicket.equalsIgnoreCase("n/a")) {
      findAttr(tray, device.getPatype(), null, myWriter);
      findAttr(tray, device.getPatype(), device.getChgname1(), myWriter);
    }

    if (StringUtils.isNotBlank(tray) & !tray.equalsIgnoreCase("n/a")) {
      findPoccnf(device.getPatype(), tray, myWriter, workbookPoccnf);
    }
    myWriter.write("\n}");
    myWriter.write("\n");
  }

  /**
   * @param patype
   * @param tray
   * @param user
   * @param myWriter
   * @param workbook
   * @throws IOException
   */
  private static void findAttr(String tray, String patype, String user, FileWriter myWriter) throws IOException {

    int longitudValueParte1 = 30;
    int longitudValueParte2 = 20;

    // List<String> patypes = new ArrayList<>();
    // patypes.add("HPLJCM1");
    // patypes.add("LXMS410");
    // patypes.add("RC000118");
    // patypes.add("RC001118");
    // patypes.add("RC001U18");
    // patypes.add("ZLXMS811");
    // patypes.add("ZHPLJCM1");
    ObjetoATTR attr = new ObjetoATTR();
    // if (patypes.contains(patype)) {
    attr.setParam("S_PRINTTICKETDEF");
    // }

    if (StringUtils.isBlank(user)) {
      attr.setLine("00000001");
    } else {
      attr.setLine("00000002");
    }

    StringBuffer buffer = new StringBuffer();
    buffer.append(tray);
    int traylength = tray.length();
    while (traylength < longitudValueParte1) {
      buffer.append(" ");
      traylength++;
    }

    if (StringUtils.isNotBlank(user)) {
      String patypeAndUser = patype + user;
      buffer.append(patypeAndUser);
      int length = patypeAndUser.length();
      while (length < longitudValueParte2) {
        buffer.append(" ");
        length++;
      }

      Date fechaDate = Calendar.getInstance().getTime();
      DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
      String fechaString = dateFormat.format(fechaDate);
      buffer.append(fechaString);

    }
    if (StringUtils.isBlank(user)) {
      int i = 0;
      if (tray.equalsIgnoreCase("BYPASS")) {
        i = 5;
      } else {
        i = Integer.parseInt(tray.substring(5, 6));
      }
      switch (i) {
        case 2:
          buffer.append("001002");
          break;
        case 3:
          buffer.append("001003");
          break;
        case 4:
          buffer.append("001004");
          break;
        case 5:
          buffer.append("001021");
          break;
      }
    }
    attr.setValue(buffer.toString());
    writeATTRtoFile(attr, myWriter);

  }

  /**
   * @param attr
   * @param myWriter
   * @throws IOException
   */
  private static void writeATTRtoFile(ObjetoATTR attr, FileWriter myWriter) throws IOException {

    myWriter.write("\n  * ATTR = {");

    myWriter.write("\n    PARAM = " + "\"" + (StringUtils.isNotBlank(attr.getParam()) ? attr.getParam() : "") + "\"");
    myWriter.write("\n    LINE = " + "\"" + (StringUtils.isNotBlank(attr.getLine()) ? attr.getLine() : "") + "\"");
    myWriter.write("\n    VALUE = " + "\"" + (StringUtils.isNotBlank(attr.getValue()) ? attr.getValue() : "") + "\"");
    myWriter.write("\n  }");

  }

  /**
   * @param patype
   * @param tray
   * @param myWriter
   * @param workbook
   * @throws IOException
   */
  private static void findPoccnf(String patype, String tray, FileWriter myWriter, Workbook workbook)
      throws IOException {

    for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
      Sheet sheet = workbook.getSheetAt(i);
      if (sheet.getSheetName().contains(patype)) {
        List<ObjetoPOCCNF> rows = new ArrayList<>();
        String selectedTray = null;
        Iterator iterator = sheet.iterator();
        while (iterator.hasNext()) {
          Row nextRow = (Row) iterator.next();
          Iterator cellIterator = nextRow.cellIterator();
          ObjetoPOCCNF poccnf = new ObjetoPOCCNF();

          while (cellIterator.hasNext()) {

            Cell cell = (Cell) cellIterator.next();
            int columnIndex = cell.getColumnIndex();
            switch (columnIndex + 1) {
              case 1:
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                  poccnf.setTray(cell.getStringCellValue());
                  selectedTray = cell.getStringCellValue();
                } else {
                  poccnf.setTray(selectedTray);
                }
                break;
              case 2:
                if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
                  poccnf.setPoption(String.valueOf((int) cell.getNumericCellValue()));
                break;
              case 3:
                if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
                  poccnf.setOptvalue(String.valueOf((int) cell.getNumericCellValue()));
                break;
              case 4:
                if (cell.getCellType() == Cell.CELL_TYPE_STRING)
                  poccnf.setAux(cell.getStringCellValue());
                break;
            }
            rows.add(poccnf);
          }
        }
        Set<ObjetoPOCCNF> objetoPOCCNFs = new LinkedHashSet<>(rows);
        for (ObjetoPOCCNF poccnf : objetoPOCCNFs) {
          if (StringUtils.isNotBlank(poccnf.getTray()) && poccnf.getTray().equalsIgnoreCase(tray)) {
            writePOCCNFtoFile(myWriter, poccnf);
          }
        }
      }
    }

  }

  /**
   * @param myWriter
   * @throws IOException
   */
  private static void writePOCCNFtoFile(FileWriter myWriter, ObjetoPOCCNF poccnf) throws IOException {

    if (StringUtils.isNotEmpty(poccnf.getPoption())) {
      myWriter.write("\n  * POCCNF = {");
      myWriter.write(
          "\n    POPTION = " + "\"" + (StringUtils.isNotBlank(poccnf.getPoption()) ? poccnf.getPoption() : "") + "\"");
      myWriter.write("\n    OPTVALUE = " + "\""
          + (StringUtils.isNotBlank(poccnf.getOptvalue()) ? poccnf.getOptvalue() : "") + "\"");
      myWriter.write("\n    AUX = " + "\""
          + ((StringUtils.isNotBlank(poccnf.getOptvalue()) && poccnf.getAux().equalsIgnoreCase("n/a")) ? ""
              : poccnf.getAux())
          + "\"");
      myWriter.write("\n  }");
    }
  }

}
