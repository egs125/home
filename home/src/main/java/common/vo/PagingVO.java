package common.vo;

public class PagingVO {
	
	private static final int NOTE_PER_PAGE = 10;	//페이지 당 게시물 수
	private static final int BLOCK_PER_PAGE = 5;	//페이지 당 페이지 블록 수
	private int totalCount;							//전체 게시물 수
	private int totalPageNum;						//전체 페이지 수
	private int totalBlockNum;						//전체 페이지블록 수
	private int curBlock;							//현재 블록 번호
	private int curPage;							//현재 페이지 번호
	private int lastPage;							//현재 블록의 마지막 페이지
	private int firstPage;							//현재 블록의 첫번째 페이지
	private int lastNote;							//현재 페이지의 마지막 게시물
	private int firstNote;							//현재 페이지의 첫번째 게시물
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public int getTotalBlockNum() {
		return totalBlockNum;
	}
	public void setTotalBlockNum(int totalBlockNum) {
		this.totalBlockNum = totalBlockNum;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastNote() {
		return lastNote;
	}
	public void setLastNote(int lastNote) {
		this.lastNote = lastNote;
	}
	public int getFirstNote() {
		return firstNote;
	}
	public void setFirstNote(int firstNote) {
		this.firstNote = firstNote;
	}
	public static int getNotePerPage() {
		return NOTE_PER_PAGE;
	}
	public static int getBlockPerPage() {
		return BLOCK_PER_PAGE;
	}
	
	public PagingVO() {}
	
	public PagingVO(int totalCount, int curPage) {
		super();
		
		this.totalCount = totalCount;
		this.curPage = curPage;
		//전체 페이지 수 = 전체 게시물 수 / 페이지 당 게시물 수  -> ceil(전체 게시물 수 / 페이지 당 게시물 수 )
		int totalPageNum = (int) Math.ceil( (double) totalCount / NOTE_PER_PAGE );
		this.totalPageNum = totalPageNum;
		
		//전체 페이지블록 수 = ceil(전체 페이지 수 / 페이지 당 페이지블록 수)
		int totalBlockNum =  (int) Math.ceil( (double) totalPageNum/ BLOCK_PER_PAGE );
		this.totalBlockNum = totalBlockNum;
		
		//현재 페이지블록 번호 = ceil(현재 페이지 번호 / 페이지 당 페이지블록수) 
		int curBlockNo = (int) Math.ceil( (double) curPage / BLOCK_PER_PAGE );
		this.curBlock = curBlockNo;
		
		//현재 블럭의 끝 페이지  = 현재 페이지블록 번호 * 페이지 당 페이지 블록 수 
		int lastPage = curBlockNo * BLOCK_PER_PAGE;
		this.lastPage = lastPage;
		
		//현제 블럭의 시작 페이지 = 현재 블럭의 끝 페이지 - 페이지 당 페이지 블록 수  + 1
		int firstPage = lastPage -  BLOCK_PER_PAGE + 1;
		this.firstPage = firstPage;
		
		//현재 페이지의 끝 글 번호 = 현재 페이지 * 페이지 당 게시물
		int lastNote = curPage * NOTE_PER_PAGE;
		this.lastNote = lastNote;
		
		//현재 페이지의 시작 글 번호  = 현재 페이지의 끝 글 번호 - 페이지 당 게시물 + 1
		int firstNote = lastNote - NOTE_PER_PAGE + 1;
		this.firstNote = firstNote;
		
		/*
		 * 전체 게시물 수   (32)
		 * 페이지 당 게시물 (10)
		 * 전체 페이지 수 = 전체 게시물 수 / 페이지 당 게시물 수  -> ceil(전체 게시물 수 / 페이지 당 게시물 수 )
		 * 
		 * 페이지 당 페이지블록 수 (5)
		 * 전체 페이지블록 수 = ceil(전체 페이지 수 / 페이지 당 페이지블록 수)
		 * 현재 페이지블록 번호 = ceil(현재 페이지 번호 / 페이지 당 페이지블록수) 
		 * 
		 * 1 2 3 4 5	 6 7 8 9 10		11 12 13 14 15		16 17 18 19 20
		 * 현재 페이지가 1 -> ceil(1 / 5) = 1
		 * 현재 페이지가 14 -> ceil(14 / 5) = 3 
		 * 
		 * 현재 블럭의 끝 페이지  = 현재 페이지블록 번호 * 페이지 당 페이지 블록 수 
		 * 현제 블럭의 시작 페이지 = 현재 블럭의 끝 번호 - 페이지 당 페이지 블록 수  + 1
		 * 
		 * 현재 페이지의 끝 글 번호 = 현재 페이지 * 페이지 당 게시물
		 * 현재 페이지의 시작 글 번호  = 현재 페이지의 끝 글 번호 - 페이지 당 게시물 + 1
		 * 
		 */
	}
	

	
	
		

}
