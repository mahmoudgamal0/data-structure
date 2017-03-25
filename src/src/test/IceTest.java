package test;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;
import eg.edu.alexu.csd.datastructure.iceHockey.cs61.PlayersFinder;

public class IceTest {

	@Test
	public void testCase1()
	{
		IPlayersFinder iceHockey = (IPlayersFinder) new PlayersFinder();
		String photo[] = {
				"33JUBU33",
				"3U3O4433",
				"O33P44NB",
				"PO3NSDP3",
				"VNDSD333",
				"OINFD33X"};
		Point[] points = {	new Point(4,5), new Point(13,9), new Point(14,2)};
		Assert.assertArrayEquals(iceHockey.findPlayers(photo,3,16), points);
	}
	
	@Test
	public void testCase2()
	{
		IPlayersFinder iceHockey = (IPlayersFinder) new PlayersFinder();
		String photo[] = {
				"44444H44S4",
				"K444K4L444",
				"4LJ44T44XH",
				"444O4VIF44",
				"44C4D4U444",
				"4V4Y4KB4M4",
				"G4W4HP4O4W",
				"4444ZDQ4S4",
				"4BR4Y4A444",
				"4G4V4T4444"};
		Point[] points = {	new Point(3,8), new Point(4,16), new Point(5,4), new Point(16,3), new Point(16,17), new Point(17,9)};
		Assert.assertArrayEquals(iceHockey.findPlayers(photo,4,16), points);
	}
		
	@Test
	public void testCase3() 
	{
		IPlayersFinder iceHockey = (IPlayersFinder) new PlayersFinder();
		String photo[] = {
				"8D88888J8L8E888",
				"88NKMG8N8E8JI88",
				"888NS8EU88HN8EO",
				"LUQ888A8TH8OIH8",
				"888QJ88R8SG88TY",
				"88ZQV88B88OUZ8O",
				"FQ88WF8Q8GG88B8",
				"8S888HGSB8FT8S8",
				"8MX88D88888T8K8",
				"8S8A88MGVDG8XK8",
				"M88S8B8I8M88J8N",
				"8W88X88ZT8KA8I8",
				"88SQGB8I8J88W88",
				"U88H8NI8CZB88B8",
				"8PK8H8T8888TQR8"};
		Point[] points = {	new Point(1, 17), new Point(3, 3), new Point(3, 10), new Point(3, 25), new Point(5, 21), new Point(8, 17),
							new Point(9, 2), new Point(10,9), new Point(12,23), new Point(17,16), new Point(18,3), new Point(18,11),
							new Point(18,28), new Point(22,20), new Point(23,26), new Point(24,15), new Point(27,2), new Point(28,26),
							new Point(29,16)};
		Assert.assertArrayEquals(iceHockey.findPlayers(photo,8,9), points);
	}

	@Test
	public void testCase4()
	{
		IPlayersFinder iceHockey = (IPlayersFinder) new PlayersFinder();
		String photo[] = {};
		Point[] points = {};
		Assert.assertArrayEquals(iceHockey.findPlayers(photo, 1, 1), points);
	}
		
	@Test
	public void testCase5()
	{
		IPlayersFinder iceHockey = (IPlayersFinder) new PlayersFinder();
		String photo[] = {	"3333333",
							"4444443",
							"4444443",
							"3333333",
							"3444444",
							"3444444",
							"3333333"};
		Point[] points = {new Point(7,7)};
		Assert.assertArrayEquals(iceHockey.findPlayers(photo, 3, 1), points);
	}
	
	@Test
	public void testCase6()
	{
		IPlayersFinder iceHockey = (IPlayersFinder) new PlayersFinder();
		String photo[] = {	"3333333",
							"4444443",
							"4444443",
							"3333333",
							"3444444",
							"3444444",
							"3333333"};
		Point[] points = {};
		Assert.assertArrayEquals(iceHockey.findPlayers(photo, 1, 1), points);
	}
	
	@Test
	public void testCase7()
	{
		IPlayersFinder iceHockey = (IPlayersFinder) new PlayersFinder();
		String photo[] = {	"1111111",
							"1111111",
							"1111111",
							"3333333",
							"3444444",
							"1111111",
							"1111111"};
		Point[] points = {new Point(7,3)};
		Assert.assertArrayEquals(iceHockey.findPlayers(photo, 1, 57), points);
	}
	
	@Test
	public void testCase8()
	{
		IPlayersFinder iceHockey = (IPlayersFinder) new PlayersFinder();
		String photo[] = {	"1U1U1U1",
							"U1U1U1U",
							"1U1U1U1",
							"U1U1U1U"};
		Point[] points = {	new Point(1,1) , new Point(1,5), new Point(3,3), new Point(3,7), new Point(5,1), new Point(5,5),
							new Point(7,3), new Point(7,7), new Point(9,1), new Point(9,5), new Point(11,3), new Point(11,7),
							new Point(13,1), new Point(13,5)};
		Assert.assertArrayEquals(iceHockey.findPlayers(photo, 1, 1), points);
	}
	
}
