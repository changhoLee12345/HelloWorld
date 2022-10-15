package gui.table;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame implements MouseListener, KeyListener {

	private static final long serialVersionUID = 1L;

	private final String[] labels = { "사원번호", "이름", "성씨", "이메일", "입사일자", "직무" };
	private JTextField[] fields = new JTextField[6];

	private JPanel topPanel;
	private JScrollPane scrolledTable;
	private JPanel rightPanel;
	private JPanel bottomPanel; // 페이지 처리용.

	private JTable table;
	private List<JButton> pageBtns;

	private JButton addBtn;
	private JButton delBtn;
	private JButton findBtn;
	private JButton initBtn;
	private JLabel showPage;

	// 현재페이지 정보를 갖고 데이터의 변경이 잇을때마다 현재페이지를 기준으로 보여주도록 하려고.
	int currentPage = 1;
	int lastPage = 100;

	ChatDAO dao = new ChatDAO();
	List<Employee> list;

	public JTableTest(String title) {
		// table 구성.
		String header[] = { "사원번호", "이름", "성씨", "이메일", "입사일자", "직무" };
		DefaultTableModel model = new DefaultTableModel(header, 0); // header추가, 행은 0개 지정

		this.setLayout(new BorderLayout(10, 10));

		{// 위쪽 입력 값 등록. topPanel.
			topPanel = new JPanel(new GridLayout(6, 4, 10, 5));

			for (int i = 0; i < 6; i++) {
				topPanel.add(new JLabel(labels[i]));
				fields[i] = new JTextField(30);
				topPanel.add(fields[i]);
			}
			topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			this.add("North", topPanel); // 가장 위쪽 Panel 설정
		}

		{ // 가운데 목록 .
			table = new JTable(model);
			scrolledTable = new JScrollPane(table); // 스크롤 될 수 있도록 JScrollPane 적용
			scrolledTable.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 너무 붙어있어서 가장자리 띄움(padding)

			this.add("Center", scrolledTable); // 가운데에 JTable 추가
		}

		{// 추가, 삭제, 조회 버튼. rightPanel.
			rightPanel = new JPanel(new GridLayout(5, 1, 10, 10));

			addBtn = new JButton("레코드 추가");
			delBtn = new JButton("레코드 삭제");
			findBtn = new JButton("레코드 조회");
			initBtn = new JButton("입력항목 초기화");
			showPage = new JLabel("Page: 1");

			rightPanel.add(addBtn);
			rightPanel.add(delBtn);
			rightPanel.add(findBtn);
			rightPanel.add(initBtn);
			rightPanel.add(showPage);
			rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

			this.add("East", rightPanel); // 오른쪽에 버튼들 추가
		}

		{ // 페이지 버튼 생성 : 전체건수(109), 페이지마다 보여줄 글 수(10)
			bottomPanel = new JPanel(new FlowLayout());
			pageBtns = new ArrayList<>();
			setPageBtn();
			add("South", bottomPanel);
		}

		{ // JFrame에 기본설정.
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(620, 500);
			this.setLocationRelativeTo(null); // 창 가운데 위치
			this.setVisible(true);
		}

		{// 이벤트 추가
			addBtn.addMouseListener(this); // 추가 처리
			delBtn.addMouseListener(this); // 삭제 처리
			findBtn.addMouseListener(this);// 조회 처리
			initBtn.addMouseListener(this); // 초기화 처리
			for (int i = 0; i < 6; i++) // 엔터 처리
				fields[i].addKeyListener(this);
			table.addMouseListener(this); // 셀 읽기 처리
		}

		initData();
	}

	private List<Employee> searchData() {
		// 조회조건을 따라 항목을 초기화 "사원번호", "이름", "성씨", "이메일", "입사일자", "직무"
		int empId = 0;
		try {
			empId = Integer.parseInt(fields[0].getText());
		} catch (Exception e) {
			empId = 0;
		}
		String firstName = fields[1].getText();
		String lastName = fields[2].getText();
		String email = fields[3].getText();
		String hireDate = fields[4].getText();
		String jobId = fields[5].getText();

		Employee emp = new Employee(empId, firstName, lastName, email, hireDate, jobId);
		list = dao.getList(emp);
		return list;
	}

	private void setPageBtn() {

		System.out.printf("pageBtns.size(): %d\n", pageBtns.size());
		for (int i = 0; i < pageBtns.size(); i++) {
			pageBtns.get(i).setVisible(false);
		}
		bottomPanel.removeAll();

//		bottomPanel.revalidate();
//		bottomPanel.repaint();

		pageBtns = new ArrayList<>();
		list = searchData();
		int totalCnt = list.size();
		lastPage = (int) Math.ceil(totalCnt / 10.0);
		System.out.printf("totalCnt: %d, lastPage: %d", totalCnt, lastPage);

		for (int i = 1; i <= lastPage; i++) {
			JButton btn = new JButton("" + i);
			System.out.println(btn + " ,created");
			btn.addActionListener(e -> {
				String currentPage = ((JButton) e.getSource()).getText();
				paging(list, Integer.parseInt(currentPage));
			});
			pageBtns.add(btn);
		}
		for (int i = 0; i < pageBtns.size(); i++)
			bottomPanel.add(pageBtns.get(i));

		System.out.printf("%d, %d", pageBtns.size(), bottomPanel.getComponents().length);
		add("South", bottomPanel);
	}

	// 항목 validate.
	private boolean isInvalidInput(String input) {
		return input == null || input.length() == 0;
	}

	// 초기 데이터 로딩.
	private void initData() {
		list = searchData();
		paging(list, 1);
	}

	// 페이징 처리
	private void paging(List<Employee> list, int page) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		// 화면클리어 후 다시 10건씩 배치.
		int allCnt = model.getRowCount();
		for (int i = 0; i < allCnt; i++) {
			model.removeRow(0);
		}

		// 페이지요청이 오면 계산해서 보여줌.
		String[] record = new String[6];
		int start, end;
		start = (page - 1) * 10;
		end = page * 10 - 1;
		for (int i = 0; i < list.size(); i++) {
			if (i >= start && i <= end) {
				record[0] = String.valueOf(list.get(i).getEmployeeId());
				record[1] = list.get(i).getFirstName();
				record[2] = list.get(i).getLastName();
				record[3] = list.get(i).getEmail();
				record[4] = list.get(i).getHireDate().substring(0, 10);
				record[5] = list.get(i).getJobId();
				model.addRow(record);
			}
		}

		currentPage = page;
		showPage.setText("Page: " + currentPage);
	}

	// 삭제
	private void removeRecord(int index) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if (index < 0) {
			if (table.getRowCount() == 0)// 비어있는 테이블이면
				return;
			index = 0;
		}
//		model.removeRow(index);

		int selectedId = Integer.parseInt((String) model.getValueAt(index, 0));
		dao.delEmp(selectedId);
		setPageBtn();
		paging(searchData(), currentPage);
	}

	// 추가
	private void addRecord() {
//		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String[] record = new String[6];
		for (int i = 0; i < 6; i++) {
			if (isInvalidInput(fields[i].getText())) {
				System.out.println("Invalid Input");
				return;
			}
			record[i] = fields[i].getText();
		}

		Employee emp = new Employee(Integer.parseInt(record[0]), record[1], record[2], record[3], record[4], record[5]);
		if (!dao.addEmp(emp)) {
			JOptionPane.showMessageDialog(null, "저장 중 에러", "경고창", JOptionPane.WARNING_MESSAGE);
			return;
		}
//		model.addRow(record);
		JOptionPane.showMessageDialog(null, "저장", "알림", JOptionPane.YES_NO_OPTION);
		initField(); // 입력항목 초기화.

	}

	// 입력항목 초기화
	private void initField() {
		for (int i = 0; i < 6; i++)
			fields[i].setText("");

		fields[0].requestFocus();
	}

	// 테이블 클릭 시
	private void printCell(int row, int col) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		System.out.println(model.getValueAt(row, col));

		int selectedId = Integer.parseInt((String) model.getValueAt(row, 0));
		Employee emp = dao.getEmpl(selectedId);

		showDetail(emp);

	}

	// 선택한 데이터의 정보를 보여주기
	private void showDetail(Employee emp) {
		fields[0].setText(String.valueOf(emp.getEmployeeId()));
		fields[1].setText(emp.getFirstName());
		fields[2].setText(emp.getLastName());
		fields[3].setText(emp.getEmail());
		fields[4].setText(emp.getHireDate());
		fields[5].setText(emp.getJobId());

	}

	// MouseListener Overrides 이벤트처리.
	@Override
	public void mouseClicked(MouseEvent e) {
		Object src = e.getSource();
		if (src == addBtn) {
			addRecord();
			setPageBtn();
		}

		if (src == delBtn) {
			int selected = table.getSelectedRow();
			removeRecord(selected);

		}

		if (src == findBtn) {
			setPageBtn();
			paging(searchData(), 1);
		}

		if (src == initBtn)
			initField();

		if (src == table) {
			int row = table.getSelectedRow();
			int col = table.getSelectedColumn();
			printCell(row, col);
		}

		// page버튼인지 체크.
		System.out.println(src);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}

	// KeyListener Overrides
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped>> " + e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed>> " + e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased>> " + e.getKeyCode());

		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_ENTER) {
			addRecord();
		}
	}

	// main method start.
	public static void main(String[] args) {
		new JTableTest("test");
	}
}