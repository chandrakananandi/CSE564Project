filename=projectproposal

all: ${filename}.pdf

${filename}.pdf: ${filename}.tex
	pdflatex ${filename}.tex
	bibtex ${filename}
	pdflatex ${filename}.tex
	pdflatex ${filename}.tex



clean: 
	@ rm -f *.ps *.log *.aux *.out  *.dvi *.bbl *.blg *.synctex.gz 


