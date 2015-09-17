
<div class="example-section">
	<h2 class="section-title">Example of Position</h2>
	<div class="section-content">
		<div class = "sub-container">
			<h2>Relative - Relate to default position</h2>
			<div class="div_relative"></div>
			<p>When selecting a typeface for young children, or anyone just
				learning to read, sans serifs are preferable, as their simplified
				letterforms are easier to recognize. 
				When selecting a typeface for young children, or anyone just
                learning to read, sans serifs are preferable, as their simplified
                letterforms are easier to recognize. 
                When selecting a typeface for young children, or anyone just
                learning to read, sans serifs are preferable, as their simplified
                letterforms are easier to recognize. 
                When selecting a typeface for young children, or anyone just
                learning to read, sans serifs are preferable, as their simplified
                letterforms are easier to recognize. </p>
			<div class="spacer"></div>
		</div>
<pre class="code">
.div_relative {
    position: relative;
    left: 380px;
    top: -20px;
    
    width: 70px;
    height: 70px;
    background-color: black;
    margin: 3px 10px;
}
</pre>
	</div>
	<div class="section-content">
        <div class = "sub-container1">
            <h2>Absolute - Absolute position with neaerest positioned element</h2>
            <div class="div_absolute"></div>
            <p>When selecting a typeface for young children, or anyone just
                learning to read, sans serifs are preferable, as their simplified
                letterforms are easier to recognize. </p>
            <div class="spacer"></div>
        </div>
<pre class="code">
.sub-container1 {
    position:relative;
    
    width: 400px;
    height: auto;
    border: 1px solid #aaa;
    background-color: #bbb;
}
.div_absolute {
    position: absolute;
    left: 380px;
    top: -20px;
    
    width: 70px;
    height: 70px;
    background-color: black;
    margin: 3px 10px;
}
</pre>
    </div>
    <div class="section-content">
        <div class = "sub-container2">
            <h2>Fixed position: absolutely with browser</h2>
            <div class="div_fixed">Fixed</div>
            <p>When selecting a typeface for young children, or anyone just
                learning to read, sans serifs are preferable, as their simplified
                letterforms are easier to recognize. </p>
            <div class="spacer"></div>
        </div>
<pre class="code">
.div_fixed {
    position: fixed;
    left: 400px;
    top: 100px;
    
    color: #fff;
    
    width: 70px;
    height: 70px;
    background-color: black;
    margin: 3px 10px;
}
</pre>
    </div>
</div>
