package ua.yaremechko.admissionsoffice.domain;

import java.sql.Date;
import java.util.List;

public class Statement {

	private Date date;
	private List<Entrant> listOfEntrants;
	private static Statement statement;

	public Statement() {
	}

	public Statement getStatement() {
		if (statement == null) {
			statement = new Statement();
		}

		return statement;
	}

	public static void setStatement(Statement statement) {
		Statement.statement = statement;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Entrant> getListOfEntrants() {
		return listOfEntrants;
	}

	public void setListOfEntrants(List<Entrant> listOfEntrants) {
		this.listOfEntrants = listOfEntrants;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((listOfEntrants == null) ? 0 : listOfEntrants.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Statement other = (Statement) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (listOfEntrants == null) {
			if (other.listOfEntrants != null)
				return false;
		} else if (!listOfEntrants.equals(other.listOfEntrants))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Statement [date=" + date + ", listOfEntrants=" + listOfEntrants + "]";
	}

}
