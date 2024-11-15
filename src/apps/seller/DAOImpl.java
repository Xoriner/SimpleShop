package apps.seller;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOImpl implements DAO {
    private Connection connection = null;

    static {
        try {

            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("Did not connect to database");
            System.out.println(e.getMessage());
        }
    }


    public DAOImpl() {
    }

    private void setConnection() throws SQLException {
        if (connection != null) {
            return;
        }
        String url = "jdbc:sqlite:offersdb";
        connection = DriverManager.getConnection(url);
    }

    private void closeConnection() throws SQLException {
        if (connection == null) {
            return;
        }
        connection.close();
        connection = null;
    }


    @Override
    public List<Offer> getAllOffers() {
        String sql = "SELECT * FROM offers";
        List<Offer> offerArrayList = new ArrayList<>();
        try {
            setConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                offerArrayList.add(new Offer(rs.getInt("id"), rs.getString("name"),
                        rs.getString("description"), rs.getInt("state")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return offerArrayList;
    }

    @Override
    public Offer getOffer(int id) {
        String sql = "SELECT * FROM offers WHERE id = ?";
        Offer offer = null;
        try {
            setConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(sql);
            if (rs.next()) {
                offer = new Offer(rs.getInt("id"), rs.getString("name"),
                        rs.getString("description"), rs.getInt("state"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return offer;
    }

    @Override
    public void addOffer(Offer offer) {
        String sql = "INSERT INTO offers (name, description, state) VALUES (?,?,?)";
        try {
            setConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOffer(Offer offer) {

    }

    @Override
    public void deleteOffer(Offer offer) {

    }

}
