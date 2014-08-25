<?xml version="1.0"?>
<!-- Fancy.xsl -->

<xsl:stylesheet 
      xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
      version="1.0">
   <xsl:output method="html"/>

   <xsl:template match="Chapter">
      <center>
         <h2>
            Chapter <xsl:value-of select="@number"/>
         </h2> 
         <h2>
            <xsl:value-of select="@title"/>
         </h2>
         <xsl:apply-templates />    
      </center>
   </xsl:template>
  
   <xsl:template match="Section">
      <h3>
         <xsl:value-of select="@title"/>
      </h3>  
      <xsl:apply-templates />    
   </xsl:template> 
  
   <xsl:template match="Subsection">
      <font face="Wingdings">J</font>
      <xsl:value-of select="@title"/>
      <font face="Wingdings">J</font><br/>
      <xsl:apply-templates />
   </xsl:template> 
  
   <xsl:template match="Subsubsection">
      &#8226; <xsl:value-of select="."/> &#8226;<br/>
   </xsl:template>   
  
</xsl:stylesheet>
