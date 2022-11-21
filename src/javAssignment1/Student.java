package javAssignment1;

public class Student {

		private String studentId;
		private String sName;
		private String loginPassword;
		
		Student(String studentId, String loginPassword) {
			this.studentId = studentId;
			this.loginPassword = loginPassword;
		}

		public String getstudentId() {
			return studentId;
		}

		public String getsName() {
			return sName;
		}

		public String getloginPassword() {
			return loginPassword;
		}


		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", sName=" + sName + ", loginPassword=" + loginPassword + "]";
		}

	
		
	}

