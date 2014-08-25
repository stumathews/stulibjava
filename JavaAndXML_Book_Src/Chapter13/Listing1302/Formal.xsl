<?xml version="1.0"?>
<!-- Formal.xsl -->

<xsl:stylesheet 
      xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
      version="1.0">
   <xsl:output method="html"/>

   <xsl:template match="Chapter">
      <h2>
         Chapter 
         <xsl:value-of select="@number"/>: 
         <xsl:value-of select="@title"/>
      </h2>
      <xsl:apply-templates />    
   </xsl:template>
  
   <xsl:template match="Section">
      <h3>
         <code>&#160;&#160;&#160;</code>
         <xsl:value-of select="@title"/>
      </h3>  
      <xsl:apply-templates />    
   </xsl:template> 
  
   <xsl:template match="Subsection">
      <code>&#160;&#160;&#160;&#160;&#160;&#160;</code>*
      <xsl:value-of select="@title"/>
      <br/>
      <xsl:apply-templates />
   </xsl:template> 
  
   <xsl:template match="Subsubsection">
      <code>&#160;&#160;&#160;&#160;&#160;
            &#160;&#160;&#160;&#160;</code>-
      <xsl:value-of select="."/>
      <br/>
   </xsl:template> 

</xsl:stylesheet>
