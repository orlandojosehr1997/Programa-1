/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.programa1;

import java.awt.Desktop;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Orlando José Hidalgo Ramírez - 2016106829
 * @author Alejandro Tapia Barboza - 2016167784
 * @author Francisco Loaiza Vallejos - 2016123417
 */
public class Interfaz extends javax.swing.JFrame {
    ArrayList<Sismo> SismoTablaMagnitud = new ArrayList();
    ArrayList<Sismo> SismoTablaFecha = new ArrayList();
    /**
     * Creates new form Interfaz
     */
    public Interfaz() 
    {
        initComponents();
    }
    public void clearTablaPrincipal()
    {
        DefaultTableModel model = (DefaultTableModel) TablaSismos.getModel();
        model.setNumRows(0);
    }
    public void updateTablaPrincipal()
    {
        clearTablaPrincipal();
        DefaultTableModel model = (DefaultTableModel) TablaSismos.getModel();
        ArrayList sismos = Listas.getListaSismos();
        for(int x=0;x<sismos.size();x++)
        {
            Sismo sismoTemporal = (Sismo)sismos.get(x);
            model.addRow(new Object[]{sismoTemporal.getFecha(),
                                  sismoTemporal.getMagnitud(),
                                  sismoTemporal.getProfundidad(),
                                  sismoTemporal.getValorMagnitud(),
                                  sismoTemporal.getOrigenStr(),
                                  sismoTemporal.getProvinciaStr(),
                                  sismoTemporal.getDescripcion(),
                                  sismoTemporal.getLatitud(),
                                  sismoTemporal.getLongitud()});
            TablaSismos.setModel(model);
        }
        Excel.crearArchivo();
    }
    public void updateFechaSismoExistenteBox()
    {
        DefaultComboBoxModel model = new DefaultComboBoxModel(Listas.getFechas());
        FechaSismoExistente.setModel(model);
    }
    public void updateSismosInfoMapa()
    {
        String fecha = (String)FechaSismoMapa.getSelectedItem();
        for (Sismo sismo : Listas.getListaSismos()) 
        {
            if (sismo.getFecha2().compareTo(fecha)==0)
            {
                MagnitudMapa.setText(sismo.getMagnitud());
                ProfundidadMapa.setText(sismo.getProfundidad());
                ValorMagMapa.setText(sismo.getValorMagnitud());
                OrigenMapa.setText(sismo.getOrigenStr());
                ProvinciaMapa.setText(sismo.getProvinciaStr());
                DescripcionMapa.setText(sismo.getDescripcion());
                LatitudMapa.setText(sismo.getLatitud());
                LongitudMapa.setText(sismo.getLongitud());
            }
        }
    }
    public void clearTablaFechas()
    {
        DefaultTableModel model = (DefaultTableModel) TablaFechas.getModel();
        model.setNumRows(0);
    }
    public void updateTablaFechas()
    {
        clearTablaFechas();
        DefaultTableModel model = (DefaultTableModel) TablaFechas.getModel();
        ArrayList sismos = SismoTablaFecha;
        for(int x=0;x<SismoTablaFecha.size();x++)
        {
            Sismo sismoTemporal = (Sismo)sismos.get(x);
            model.addRow(new Object[]{sismoTemporal.getFecha(),
                                  sismoTemporal.getMagnitud(),
                                  sismoTemporal.getProfundidad(),
                                  sismoTemporal.getValorMagnitud(),
                                  sismoTemporal.getOrigenStr(),
                                  sismoTemporal.getProvinciaStr(),
                                  sismoTemporal.getDescripcion(),
                                  sismoTemporal.getLatitud(),
                                  sismoTemporal.getLongitud()});
            TablaFechas.setModel(model);
        }
    }
    public void clearTablaMagnitud()
    {
        DefaultTableModel model = (DefaultTableModel) TablaMagnitud.getModel();
        model.setNumRows(0);
    }
    public void updateTablaMagnitud()
    {
        clearTablaMagnitud();
        DefaultTableModel model = (DefaultTableModel) TablaMagnitud.getModel();
        ArrayList sismos = SismoTablaMagnitud;
        for(int x=0;x<SismoTablaMagnitud.size();x++)
        {
            Sismo sismoTemporal = (Sismo)sismos.get(x);
            model.addRow(new Object[]{sismoTemporal.getFecha(),
                                  sismoTemporal.getMagnitud(),
                                  sismoTemporal.getProfundidad(),
                                  sismoTemporal.getValorMagnitud(),
                                  sismoTemporal.getOrigenStr(),
                                  sismoTemporal.getProvinciaStr(),
                                  sismoTemporal.getDescripcion(),
                                  sismoTemporal.getLatitud(),
                                  sismoTemporal.getLongitud()});
            TablaMagnitud.setModel(model);
        }
    }
    
    public void SendMail(String correo, Sismo sismo) {
        String username = "prograpoo16@gmail.com" ;
        String password = "qz1wx2ec3rv4";
        String Mensage = "Un sismo de "+ sismo.getMagnitud() + " fue reportado en "+ sismo.getProvinciaStr() +".\n\n" +
                "\t-Fecha y hora del sismo: " + sismo.getFecha()+".\n"+
                "\t-Provincia: " + sismo.getProvinciaStr()+".\n"+
                "\t-Magnitud: " + sismo.getMagnitud()+".\n"+
                "\t-Valor de magnitud: " + sismo.getValorMagnitud()+"\n" +
                "\t-Profundidad: " + sismo.getProfundidad()+".\n"+
                "\t-Origen: " + sismo.getOrigenStr() + ".\n" +
                "\t-Descripción: " + sismo.getDescripcion()+".\n"+
                "\t-Ubicacion exacta: \n"+
                "\t\tLatitud:"+sismo.getLatitud() +"\n"+
                "\t\tLongitud:"+sismo.getLongitud();
        String To = correo;
        String Subject = "Nuevo Sismo Reportado en " + sismo.getProvinciaStr();
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        //return new PasswordAuthentication(Username, PassWord);
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(To));
            message.setSubject(Subject);
            message.setText(Mensage);

            Transport.send(message);
            //JOptionPane.showMessageDialog(this, "Su mensaje ha sido enviado");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaSismos = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Fecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Magnitud = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Profundidad = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        OrigenSismo = new javax.swing.JComboBox(Origen.values());
        jLabel13 = new javax.swing.JLabel();
        ProvinciaSismo = new javax.swing.JComboBox(Provincia.values());
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Descripcion = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Latitud = new javax.swing.JTextField();
        Longitud = new javax.swing.JTextField();
        RegistrarSismo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        FechaSismoExistente = new javax.swing.JComboBox(Listas.getFechas());
        jLabel9 = new javax.swing.JLabel();
        EditarFecha = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        EditarMagnitud = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        EditarProfundidad = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        EditarOrigen = new javax.swing.JComboBox(Origen.values());
        jLabel19 = new javax.swing.JLabel();
        EditarProvincia = new javax.swing.JComboBox(Provincia.values());
        jLabel20 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        EditarDescripción = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        EditarLatitud = new javax.swing.JTextField();
        EditarLongitud = new javax.swing.JTextField();
        BorrarSismo = new javax.swing.JButton();
        GuardarCambios = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        NombreUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Correo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Celular = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        SJ = new javax.swing.JCheckBox();
        Cartago = new javax.swing.JCheckBox();
        Alajuela = new javax.swing.JCheckBox();
        Heredia = new javax.swing.JCheckBox();
        Limon = new javax.swing.JCheckBox();
        Puntarenas = new javax.swing.JCheckBox();
        Guanacaste = new javax.swing.JCheckBox();
        OPacifico = new javax.swing.JCheckBox();
        MCaribe = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        notificarCorreo = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        notificarCelular = new javax.swing.JRadioButton();
        RegistrarUsuario = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        Graficos = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        Fecha1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        Fecha2 = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        ConfirmarRangoFechas = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaFechas = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        ValorMagnitudTabla = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaMagnitud = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        FechaSismoMapa = new javax.swing.JComboBox(Listas.getFechas());
        jLabel30 = new javax.swing.JLabel();
        MagnitudMapa = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        ProfundidadMapa = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        ValorMagMapa = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        OrigenMapa = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        ProvinciaMapa = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        DescripcionMapa = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        LatitudMapa = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        LongitudMapa = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        VisualizarMapa = new javax.swing.JButton();

        jPanel14.setLayout(new java.awt.GridLayout(1, 2));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jTabbedPane1.setToolTipText("Sismos");

        TablaSismos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Magnitud", "Profundidad", "Valor Magnitud", "Origen", "Provincia", "Descripcion", "Latitud", "Longitud"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TablaSismos);

        jTabbedPane1.addTab("Sismos", jScrollPane2);

        jPanel2.setLayout(new java.awt.GridLayout(8, 2));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Fecha y Hora (Formato: dd/MM/yyyy HH:mm:ss)");
        jPanel2.add(jLabel8);
        jPanel2.add(Fecha);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Magnitud");
        jPanel2.add(jLabel10);

        Magnitud.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Magnitud.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                MagnitudFocusGained(evt);
            }
        });
        jPanel2.add(Magnitud);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Profundidad (kilómetros)");
        jPanel2.add(jLabel11);

        Profundidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfundidadActionPerformed(evt);
            }
        });
        jPanel2.add(Profundidad);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Origen");
        jPanel2.add(jLabel12);

        OrigenSismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrigenSismoActionPerformed(evt);
            }
        });
        jPanel2.add(OrigenSismo);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Provincia");
        jPanel2.add(jLabel13);

        jPanel2.add(ProvinciaSismo);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Descripción");
        jPanel2.add(jLabel14);

        Descripcion.setColumns(20);
        Descripcion.setRows(5);
        jScrollPane1.setViewportView(Descripcion);

        jPanel2.add(jScrollPane1);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Ubicación Exacta (Latitud,Longitud)");
        jPanel2.add(jLabel15);

        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        Latitud.setToolTipText("");
        Latitud.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                LatitudFocusGained(evt);
            }
        });
        Latitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LatitudActionPerformed(evt);
            }
        });
        jPanel5.add(Latitud);

        Longitud.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                LongitudFocusGained(evt);
            }
        });
        Longitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LongitudActionPerformed(evt);
            }
        });
        jPanel5.add(Longitud);

        jPanel2.add(jPanel5);

        RegistrarSismo.setText("Registrar");
        RegistrarSismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarSismoActionPerformed(evt);
            }
        });
        jPanel2.add(RegistrarSismo);

        jTabbedPane2.addTab("Nuevo Sismo", jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(9, 2));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fecha del Sismo a Editar");
        jPanel3.add(jLabel1);

        jPanel3.add(FechaSismoExistente);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Fecha y Hora (Formato: dd/MM/yyyy HH:mm:ss)");
        jPanel3.add(jLabel9);
        jPanel3.add(EditarFecha);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Magnitud");
        jPanel3.add(jLabel16);
        jPanel3.add(EditarMagnitud);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Profundidad (kilómetros)");
        jPanel3.add(jLabel17);
        jPanel3.add(EditarProfundidad);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Origen");
        jPanel3.add(jLabel18);

        jPanel3.add(EditarOrigen);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Provincia");
        jPanel3.add(jLabel19);

        jPanel3.add(EditarProvincia);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Descripción");
        jPanel3.add(jLabel20);

        EditarDescripción.setColumns(20);
        EditarDescripción.setRows(5);
        jScrollPane4.setViewportView(EditarDescripción);

        jPanel3.add(jScrollPane4);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Ubicación Exacta (Latitud,Longitud)");
        jPanel3.add(jLabel21);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));
        jPanel4.add(EditarLatitud);
        jPanel4.add(EditarLongitud);

        jPanel3.add(jPanel4);

        BorrarSismo.setText("Borrar Sismo");
        BorrarSismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarSismoActionPerformed(evt);
            }
        });
        jPanel3.add(BorrarSismo);

        GuardarCambios.setText("Guardar Cambios");
        GuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarCambiosActionPerformed(evt);
            }
        });
        jPanel3.add(GuardarCambios);

        jTabbedPane2.addTab("Editar Sismo", jPanel3);

        jTabbedPane1.addTab("Registrar Sismo", jTabbedPane2);

        jPanel1.setLayout(new java.awt.GridLayout(7, 2));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2);
        jPanel1.add(NombreUsuario);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Correo");
        jPanel1.add(jLabel3);
        jPanel1.add(Correo);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Celular");
        jPanel1.add(jLabel4);
        jPanel1.add(Celular);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Provincias");
        jPanel1.add(jLabel5);

        jPanel7.setLayout(new java.awt.GridLayout(3, 3));

        SJ.setText("San José");
        jPanel7.add(SJ);

        Cartago.setText("Cartago");
        jPanel7.add(Cartago);

        Alajuela.setText("Alajuela");
        jPanel7.add(Alajuela);

        Heredia.setText("Heredia");
        jPanel7.add(Heredia);

        Limon.setText("Limon");
        jPanel7.add(Limon);

        Puntarenas.setText("Puntarenas");
        jPanel7.add(Puntarenas);

        Guanacaste.setText("Guanacaste");
        jPanel7.add(Guanacaste);

        OPacifico.setText("Océano Pacífico");
        jPanel7.add(OPacifico);

        MCaribe.setText("Mar Caribe");
        jPanel7.add(MCaribe);

        jPanel1.add(jPanel7);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Notificar Correo");
        jPanel1.add(jLabel6);
        jPanel1.add(notificarCorreo);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Notificar Celular");
        jPanel1.add(jLabel7);
        jPanel1.add(notificarCelular);

        RegistrarUsuario.setText("Registrar");
        RegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(RegistrarUsuario);

        jTabbedPane4.addTab("Nuevo Usuario", jPanel1);

        jTabbedPane1.addTab("Registrar Usuario", jTabbedPane4);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        Graficos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                GraficosFocusGained(evt);
            }
        });
        Graficos.addTab("# Sismos por Provincia", jPanel8);
        Graficos.addTab("# Sismos por Tipo de Origen", jPanel9);

        jPanel10.setLayout(new java.awt.GridLayout(2, 0));

        jPanel16.setLayout(new java.awt.GridLayout(3, 2));

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("De esta fecha:");
        jPanel16.add(jLabel23);
        jPanel16.add(Fecha1);

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Hasta esta fecha:");
        jPanel16.add(jLabel25);
        jPanel16.add(Fecha2);
        jPanel16.add(jPanel17);

        ConfirmarRangoFechas.setText("Confirmar");
        ConfirmarRangoFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarRangoFechasActionPerformed(evt);
            }
        });
        jPanel16.add(ConfirmarRangoFechas);

        jPanel10.add(jPanel16);

        TablaFechas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Magnitud", "Profundidad", "Valor Magnitud", "Origen", "Provincia", "Descripcion", "Latitud", "Longitud"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TablaFechas);

        jPanel10.add(jScrollPane3);

        Graficos.addTab("Sismos en Rango de Fechas", jPanel10);
        Graficos.addTab("# Sismos por mes en un año", jPanel11);

        jPanel12.setLayout(new java.awt.GridLayout(2, 1));

        jPanel18.setLayout(new java.awt.GridLayout(1, 2));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Valor de Magnitud:");
        jPanel18.add(jLabel27);

        ValorMagnitudTabla.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Micro", "Ligero", "Moderado", "Fuerte", "Mayor", "Gran", "Épico" }));
        ValorMagnitudTabla.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ValorMagnitudTablaItemStateChanged(evt);
            }
        });
        ValorMagnitudTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorMagnitudTablaActionPerformed(evt);
            }
        });
        jPanel18.add(ValorMagnitudTabla);

        jPanel12.add(jPanel18);

        TablaMagnitud.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Magnitud", "Profundidad", "Valor de Magnitud", "Origen", "Provincia", "Descripción", "Latitud", "Longitud"
            }
        ));
        jScrollPane5.setViewportView(TablaMagnitud);

        jPanel12.add(jScrollPane5);

        Graficos.addTab("Sismos por Magnitud", jPanel12);

        jPanel6.add(Graficos);

        jTabbedPane1.addTab("Gráficos", jPanel6);

        jPanel13.setLayout(new java.awt.GridLayout(10, 2));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Fecha del Sismo que desea visualizar en el mapa:");
        jPanel13.add(jLabel22);

        FechaSismoMapa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FechaSismoMapaItemStateChanged(evt);
            }
        });
        jPanel13.add(FechaSismoMapa);

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Magnitud");
        jPanel13.add(jLabel30);
        jPanel13.add(MagnitudMapa);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Profundidad");
        jPanel13.add(jLabel24);
        jPanel13.add(ProfundidadMapa);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Valor de Magnitud");
        jPanel13.add(jLabel26);
        jPanel13.add(ValorMagMapa);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Origen");
        jPanel13.add(jLabel28);
        jPanel13.add(OrigenMapa);

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Provincia");
        jPanel13.add(jLabel34);
        jPanel13.add(ProvinciaMapa);

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Descripcion");
        jPanel13.add(jLabel33);
        jPanel13.add(DescripcionMapa);

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Latitud");
        jPanel13.add(jLabel37);
        jPanel13.add(LatitudMapa);

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Longitud");
        jPanel13.add(jLabel31);
        jPanel13.add(LongitudMapa);
        jPanel13.add(jPanel15);

        VisualizarMapa.setText("Visualizar en Mapa");
        VisualizarMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizarMapaActionPerformed(evt);
            }
        });
        jPanel13.add(VisualizarMapa);

        jTabbedPane1.addTab("Ver en Mapa", jPanel13);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LongitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LongitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LongitudActionPerformed

    private void OrigenSismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrigenSismoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrigenSismoActionPerformed

    private void LatitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LatitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LatitudActionPerformed

    private void LatitudFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LatitudFocusGained
       
    }//GEN-LAST:event_LatitudFocusGained

    private void LongitudFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LongitudFocusGained
   
    }//GEN-LAST:event_LongitudFocusGained

    private void MagnitudFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MagnitudFocusGained
       
    }//GEN-LAST:event_MagnitudFocusGained

    private void ProfundidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfundidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfundidadActionPerformed

    private void RegistrarSismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarSismoActionPerformed
        String fecha = Fecha.getText();
        String profundidad = Profundidad.getText();
        Origen origen = (Origen)OrigenSismo.getSelectedItem();
        String magnitud = Magnitud.getText();
        String latitud = Latitud.getText();
        String longitud = Longitud.getText();
        String descripcion = Descripcion.getText();
        Provincia provincia = (Provincia)ProvinciaSismo.getSelectedItem();
       
        Sismo s1 = new Sismo(fecha,magnitud,profundidad,origen,provincia,latitud,longitud,descripcion);
        
        Fecha.setText("");
        Profundidad.setText("");
        Magnitud.setText("");
        Latitud.setText("");
        Longitud.setText("");
        Descripcion.setText("");
        
        Listas.agregarSismo(s1);
        for (Cliente cliente : Listas.getListaClientes()) 
        {
            if (cliente.isInteresado(s1.getProvincia())&&cliente.isNotificarCorreo())
                    SendMail(cliente.getCorreo(),s1);
        }
        updateTablaPrincipal();
        updateFechaSismoExistenteBox();
    }//GEN-LAST:event_RegistrarSismoActionPerformed

    private void RegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarUsuarioActionPerformed
        ArrayList<Provincia> listaProvincias = new ArrayList();
        if (SJ.isSelected())
            listaProvincias.add(Provincia.San_José);
        if (Cartago.isSelected())
            listaProvincias.add(Provincia.Cartago);
        if (Alajuela.isSelected())
            listaProvincias.add(Provincia.Alajuela);
        if (Heredia.isSelected())
            listaProvincias.add(Provincia.Heredia);
        if (Limon.isSelected())
            listaProvincias.add(Provincia.Limón);
        if (Puntarenas.isSelected())
            listaProvincias.add(Provincia.Puntarenas);
        if (Guanacaste.isSelected())
            listaProvincias.add(Provincia.Guanacaste);
        if (OPacifico.isSelected())
            listaProvincias.add(Provincia.Oceano_Pacífico);
        if (MCaribe.isSelected())
            listaProvincias.add(Provincia.Mar_Caribe);
        if (listaProvincias.isEmpty())
            listaProvincias.add(Provincia.Sin_Asignar);
        
        Cliente c1 = new Cliente(NombreUsuario.getText(),
                Correo.getText(),
                Celular.getText(),
                listaProvincias,
                notificarCorreo.isSelected(),
                notificarCelular.isSelected());
        Listas.agregarCliente(c1);
        
        Correo.setText("");
        Celular.setText("");
        SJ.setSelected(false);
        Cartago.setSelected(false);
        Alajuela.setSelected(false);
        Heredia.setSelected(false);
        Limon.setSelected(false);
        Puntarenas.setSelected(false);
        Guanacaste.setSelected(false);
        OPacifico.setSelected(false);
        MCaribe.setSelected(false);
        notificarCorreo.setSelected(false);
        notificarCelular.setSelected(false);
    }//GEN-LAST:event_RegistrarUsuarioActionPerformed

    private void BorrarSismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarSismoActionPerformed
        String fecha = (String) FechaSismoExistente.getSelectedItem();
        ArrayList<Sismo> listaSismos = Listas.getListaSismos();
        for (Sismo sismo : listaSismos) 
        {
            if (sismo.getFecha2().compareTo(fecha)==0)
            {
               listaSismos.remove(sismo);       
               break;
            }
        }
        updateTablaPrincipal();
        updateFechaSismoExistenteBox();
        EditarFecha.setText("");
        EditarMagnitud.setText("");
        EditarProfundidad.setText("");
        EditarDescripción.setText("");
        EditarLatitud.setText("");
        EditarLongitud.setText("");
    }//GEN-LAST:event_BorrarSismoActionPerformed

    private void GuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarCambiosActionPerformed
        String fecha = (String) FechaSismoExistente.getSelectedItem();
        ArrayList<Sismo> listaSismos = Listas.getListaSismos();
        for (Sismo sismo : listaSismos) 
        {
            if (sismo.getFecha2().compareTo(fecha)==0)
            {
               sismo.setFecha(EditarFecha.getText());
               sismo.setMagnitud(EditarMagnitud.getText());
               sismo.setProfundidad(EditarProfundidad.getText());
               sismo.setOrigen((Origen)EditarOrigen.getSelectedItem());
               sismo.setProvincia((Provincia)EditarProvincia.getSelectedItem());
               sismo.setDescripcion(EditarDescripción.getText());
               sismo.setLatitud(EditarLatitud.getText());
               sismo.setLongitud(EditarLongitud.getText());
               break;
            }
        }
        updateTablaPrincipal();
        updateFechaSismoExistenteBox();
    }//GEN-LAST:event_GuardarCambiosActionPerformed

    private void GraficosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GraficosFocusGained
        BarChart_AWT sismosProvincia = new BarChart_AWT("","Cantidad de sismos por Provincia","");
        jPanel8.removeAll();
        jPanel8.add(sismosProvincia.getContentPane());
        
        PieChart_AWT sismosTipoOrigen = new PieChart_AWT("Cantidad de sismos por tipo de origen");
        jPanel9.removeAll();
        jPanel9.add(sismosTipoOrigen.getContentPane());
        
        BarChart_AWT sismosMes = new BarChart_AWT("","Cantidad de sismos por Mes");
        jPanel11.removeAll();
        jPanel11.add(sismosMes.getContentPane());
        
    }//GEN-LAST:event_GraficosFocusGained

    private void FechaSismoMapaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FechaSismoMapaItemStateChanged
        updateSismosInfoMapa();
    }//GEN-LAST:event_FechaSismoMapaItemStateChanged

    private void VisualizarMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizarMapaActionPerformed
        String fecha = (String)FechaSismoMapa.getSelectedItem();
        for (Sismo sismo : Listas.getListaSismos()) 
        {
            if (sismo.getFecha2().compareTo(fecha)==0)
            {
                String x=sismo.getLatitud();
                String y=sismo.getLongitud();
                String coordenada=x+"+"+y;

                try {
                Desktop.getDesktop().browse(new URI("http://www.google.com/maps/place/"+coordenada));
                } catch (Exception e) {
                }
            }
        }  
    }//GEN-LAST:event_VisualizarMapaActionPerformed

    private void ValorMagnitudTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorMagnitudTablaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorMagnitudTablaActionPerformed

    private void ValorMagnitudTablaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ValorMagnitudTablaItemStateChanged
        SismoTablaMagnitud.clear();
        String valor = (String)ValorMagnitudTabla.getSelectedItem();
        for (Sismo sismo : Listas.getListaSismos()) 
        {
            if (valor.compareTo(sismo.getValorMagnitud())==0)
                SismoTablaMagnitud.add(sismo);
        }
        updateTablaMagnitud();
    }//GEN-LAST:event_ValorMagnitudTablaItemStateChanged

    private void ConfirmarRangoFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarRangoFechasActionPerformed
        SismoTablaFecha.clear();
        String fecha1 = (String)Fecha1.getText();
        String fecha2 = (String)Fecha2.getText();
        String formatoFecha = "dd/MM/yyyy HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(formatoFecha);
        try 
        {
            Date date1 = format.parse(fecha1);
            Date date2 = format.parse(fecha2);
            if (date1.after(date2))
            {
                Date tempo = date1;
                date1 = date2;
                date2 = tempo;
            }
            for (Sismo sismo : Listas.getListaSismos()) 
            {
                if(date1.before(sismo.getFechaDate())&&date2.after(sismo.getFechaDate()))
                    SismoTablaFecha.add(sismo);
            }
            updateTablaFechas();
        }
        catch (ParseException e) 
        {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_ConfirmarRangoFechasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Alajuela;
    private javax.swing.JButton BorrarSismo;
    private javax.swing.JCheckBox Cartago;
    private javax.swing.JTextField Celular;
    private javax.swing.JButton ConfirmarRangoFechas;
    private javax.swing.JTextField Correo;
    private javax.swing.JTextArea Descripcion;
    private javax.swing.JLabel DescripcionMapa;
    private javax.swing.JTextArea EditarDescripción;
    private javax.swing.JTextField EditarFecha;
    private javax.swing.JTextField EditarLatitud;
    private javax.swing.JTextField EditarLongitud;
    private javax.swing.JTextField EditarMagnitud;
    private javax.swing.JComboBox EditarOrigen;
    private javax.swing.JTextField EditarProfundidad;
    private javax.swing.JComboBox EditarProvincia;
    private javax.swing.JTextField Fecha;
    private javax.swing.JTextField Fecha1;
    private javax.swing.JTextField Fecha2;
    private javax.swing.JComboBox FechaSismoExistente;
    private javax.swing.JComboBox FechaSismoMapa;
    private javax.swing.JTabbedPane Graficos;
    private javax.swing.JCheckBox Guanacaste;
    private javax.swing.JButton GuardarCambios;
    private javax.swing.JCheckBox Heredia;
    private javax.swing.JTextField Latitud;
    private javax.swing.JLabel LatitudMapa;
    private javax.swing.JCheckBox Limon;
    private javax.swing.JTextField Longitud;
    private javax.swing.JLabel LongitudMapa;
    private javax.swing.JCheckBox MCaribe;
    private javax.swing.JTextField Magnitud;
    private javax.swing.JLabel MagnitudMapa;
    private javax.swing.JTextField NombreUsuario;
    private javax.swing.JCheckBox OPacifico;
    private javax.swing.JLabel OrigenMapa;
    private javax.swing.JComboBox OrigenSismo;
    private javax.swing.JTextField Profundidad;
    private javax.swing.JLabel ProfundidadMapa;
    private javax.swing.JLabel ProvinciaMapa;
    private javax.swing.JComboBox ProvinciaSismo;
    private javax.swing.JCheckBox Puntarenas;
    private javax.swing.JButton RegistrarSismo;
    private javax.swing.JButton RegistrarUsuario;
    private javax.swing.JCheckBox SJ;
    private javax.swing.JTable TablaFechas;
    private javax.swing.JTable TablaMagnitud;
    private javax.swing.JTable TablaSismos;
    private javax.swing.JLabel ValorMagMapa;
    private javax.swing.JComboBox ValorMagnitudTabla;
    private javax.swing.JButton VisualizarMapa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JRadioButton notificarCelular;
    private javax.swing.JRadioButton notificarCorreo;
    // End of variables declaration//GEN-END:variables
}
