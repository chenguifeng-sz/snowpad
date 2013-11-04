package com.xiboliya.snowpad;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeSelectionModel;

/**
 * "��������"JFrame����
 * 
 * @author ��ԭ
 * 
 */
public class HelpFrame extends JFrame implements TreeSelectionListener {
  private static final long serialVersionUID = 1L;
  private JPanel pnlMain = (JPanel) this.getContentPane();
  private StringBuilder stbTitle = new StringBuilder(Util.HELP_TITLE); // �������ַ���
  private JSplitPane spnMain = new JSplitPane();
  private BaseTreeNode treeNode = new BaseTreeNode(Util.SOFTWARE);
  private JTree treeMain = new JTree(treeNode);
  private JTextArea txaMain = new JTextArea();

  public HelpFrame() {
    this.setTitle(this.stbTitle.toString());
    this.setSize(400, 400);
    this.setMinimumSize(new Dimension(300, 300)); // �������������С�ߴ�
    this.setLocationRelativeTo(null); // ʹ���ھ�����ʾ
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.init();
    this.initTree();
    this.setIcon();
    this.addListeners();
    this.setVisible(true);
  }

  /**
   * ��ʼ������
   */
  private void init() {
    this.pnlMain.add(this.spnMain);
    this.spnMain.setLeftComponent(new JScrollPane(this.treeMain));
    this.spnMain.setRightComponent(new JScrollPane(this.txaMain));
    this.spnMain.setDividerLocation(0.3);
    this.treeMain.getSelectionModel().setSelectionMode(
        TreeSelectionModel.SINGLE_TREE_SELECTION); // ����JTree���һ��ֻ��ѡ��һ���ڵ�
    this.txaMain.setEditable(false);
    this.txaMain.setLineWrap(true);
    this.txaMain.setTabSize(2);
  }

  /**
   * ��ʼ��JTree���
   */
  private void initTree() {
    BaseTreeNode treeNodeLevel1 = null;
    BaseTreeNode treeNodeLevel2 = null;
    BaseTreeNode treeNodeLevel3 = null;
    URL url = ClassLoader.getSystemResource("res/help.res");
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new InputStreamReader(url.openStream(),
          "GB18030"));
      String line = reader.readLine();
      while (line != null) {
        if (line.trim().length() < 3) {
          line = reader.readLine();
          continue;
        }
        char type = line.charAt(0);
        String[] splitLine = line.substring(1).split(Util.PARAM_SPLIT, -1);
        switch (type) {
        case '0':
          this.treeNode.setContent(Util.transfer(splitLine[0]));
          break;
        case '1':
          treeNodeLevel1 = new BaseTreeNode(splitLine[0], Util
              .transfer(splitLine[1]));
          this.treeNode.add(treeNodeLevel1);
          break;
        case '2':
          if (treeNodeLevel1 != null) {
            treeNodeLevel1.add(treeNodeLevel2 = new BaseTreeNode(splitLine[0],
                Util.transfer(splitLine[1])));
          }
          break;
        case '3':
          if (treeNodeLevel2 != null) {
            treeNodeLevel2.add(treeNodeLevel3 = new BaseTreeNode(splitLine[0],
                Util.transfer(splitLine[1])));
          }
          break;
        case '4':
          if (treeNodeLevel3 != null) {
            treeNodeLevel3.add(new BaseTreeNode(splitLine[0], Util
                .transfer(splitLine[1])));
          }
          break;
        }
        line = reader.readLine();
      }
    } catch (Exception x) {
      x.printStackTrace();
    } finally {
      try {
        reader.close();
      } catch (IOException x) {
        x.printStackTrace();
      }
    }
  }

  /**
   * �����Զ���Ĵ���ͼ��
   */
  private void setIcon() {
    try {
      this.setIconImage(Util.SW_ICON.getImage());
    } catch (Exception x) {
      x.printStackTrace();
    }
  }

  /**
   * ����¼�������
   */
  private void addListeners() {
    this.treeMain.addTreeSelectionListener(this);
  }

  /**
   * ��������JTree���ѡ�����仯ʱ�����������¼�
   */
  public void valueChanged(TreeSelectionEvent e) {
    BaseTreeNode treeNode = (BaseTreeNode) this.treeMain
        .getLastSelectedPathComponent();
    if (treeNode == null) {
      return;
    }
    this.stbTitle = new StringBuilder(Util.HELP_TITLE + " - "
        + treeNode.toString());
    this.setTitle(this.stbTitle.toString());
    this.txaMain.setText(treeNode.getContent());
  }

}
