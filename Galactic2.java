// Arup Guha
// 12/3/2017
// Solution to 2017 NCPC Problem G: Gallactic Collegiate Programming Contest

import java.util.*;
import java.io.*;

public class g {

	public static int n;

	public static void main(String[] args) throws Exception {

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(stdin.readLine());
		n = Integer.parseInt(tok.nextToken());
		int events = Integer.parseInt(tok.nextToken());

		// Set up all teams.
		team[] list = new team[n];
		boolean[] in = new boolean[n];
		int res = 0;
		for (int i=0; i<n; i++) list[i] = new team(i);

		// Better teams than me go here.
		TreeSet<team> better = new TreeSet<team>();

		// Store answer here.
		StringBuffer sb = new StringBuffer();

		// Go through each event.
		for (int i=0; i<events; i++) {

			// Get team, penalty.
			tok = new StringTokenizer(stdin.readLine());
			int team = Integer.parseInt(tok.nextToken()) - 1;
			int pen = Integer.parseInt(tok.nextToken());

			// Update this team.
			if (in[team]) better.remove(list[team]);
			list[team].add(pen);

			// This team has jumped ahead of us.
			if (team != 0 && list[team].compareTo(list[0]) > 0) {
				if (!in[team]) res++;
				in[team] = true;
				better.add(list[team]);
			}

			// We got better!
			else if (team == 0) {

				// Get rid of teams that aren't better than us!
				while (better.size() > 0 && better.first().compareTo(list[0]) <= 0) {
					res--;
					in[better.pollFirst().ID] = false;
				}
			}

			sb.append((res+1)+"\n");
		}

		// Ta da!
		System.out.print(sb);
	}
}

// Manages a team.
class team implements Comparable<team> {

	public int ID;
	public int score;
	public int penalty;

	public team(int i) {
		ID = i;
		score = 0;
		penalty = 0;
	}

	// Get a question.
	public void add(int pen) {
		score++;
		penalty += pen;
	}

	// Careful here to never have ties!
	public int compareTo(team other) {
		if (this.score != other.score) return this.score - other.score;
		if (this.penalty != other.penalty) return other.penalty - this.penalty;
		return other.ID - this.ID;
	}
}