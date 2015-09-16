
<div class="example-section">
	<h2 class="section-title">Example of Table</h2>
	<div class="section-content">
		<table class="table1">
			<tr>
				<th>Year</th>
				<th>2006</th>
				<th>2008</th>
			</tr>
			<tr>
				<th>Best 1</th>
				<td>Film 1</td>
				<td>Film B</td>
			</tr>
			<tr>
				<th>Best 2</th>
				<td>Film 2</td>
				<td>Film A</td>
			</tr>
		</table>
		<pre class="code">
.table1 {
    font: normal 13px ,Verdana,sans-serif;
    border: 1px solid blue;
}
table.table1 td, th {
    padding:3px;
}

table.table1 th {
    text-align:left;
    color:#FFF;
    background-color:#333;
    line-height: 2em;
}

table.table1 th, td {
    border:1px solid #333;
}

table.table1 td {
    width: 100px;
    line-height: 2em;
    background-color: #ccc;
}
</pre>
	</div>
	<div class="section-content">
        <table class="table2">
            <tr>
                <th>Year</th>
                <th>2006</th>
                <th>2008</th>
            </tr>
            <tr>
                <th>Best 1</th>
                <td>Film 1</td>
                <td>Film B</td>
            </tr>
            <tr>
                <th>Best 2</th>
                <td>Film 2</td>
                <td>Film A</td>
            </tr>
        </table>
        <pre class="code">
.table2 {
    font: normal 13px Verdana,sans-serif;
    border-collapse: collapse;
}
table.table2 td, th {
    padding:3px;
}

table.table2 th {
    text-align:left;
    line-height: 2em;
}

table.table2 th, td {
    border-bottom:1px solid #333;
    border-left: 0px;
    border-right: 0px;
    border-top: 0px;
}

table.table2 td {
    width: 100px;
    line-height: 2em;
}
</pre>

    </div>
</div>
