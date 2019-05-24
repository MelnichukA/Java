#include <iostream>
#include <string>
#include <vector>
 
namespace cf{
    
    class Object{
        protected:
            std::string title;
            std::string fio;
            Object(const std::string & _title, const std::string & _fio) : 
                        title(_title), fio(_fio){}
        public:
            void setTitle(const std::string & _title){
                title = _title;
            }
            const std::string & getTitle() const{
                return title;
            }
            void setFIO(const std::string & _fio){
                fio = _fio;
            }
            const std::string & getFIO() const {
                return title;
            }
            virtual void print() const = 0;
            virtual ~Object(){}
    };
    
    class PaperObject : public Object{
        protected:
            size_t yearMake;
        public:
            PaperObject(const std::string & _title, const std::string & _fio , size_t _yearMake) : 
                                    Object(_title, _fio), yearMake(_yearMake){}
            void setYearMake(size_t _yearMake){
                yearMake = _yearMake;
            }
            size_t getYearMake() const {
                return yearMake;
            }
            virtual void print() const = 0;
            virtual ~PaperObject(){}
    };
    
    class Book : PaperObject{
        protected:
            std::string publishingHouse;
        public:
            Book(const std::string & _title, const std::string & _fio, size_t _yearMake,
                     const std::string & _publishingHouse) : PaperObject(_title, _fio, _yearMake),
                     publishingHouse(_publishingHouse){}
            void setPubHouse(const std::string & _publishingHouse){
                publishingHouse = _publishingHouse;
            }
            const std::string & getPubHouse() const{
                return publishingHouse;
            }
            virtual void print() const{
                std::cout << "Book " << std::endl;
                std::cout << "Title : " << title << std::endl;
                std::cout << "FIO author : " << fio << std::endl;
                std::cout << "Year make : " << yearMake << std::endl;
                std::cout << "Publishing house : " << publishingHouse << std::endl;
                std::cout << std::endl;
            }
            virtual ~Book(){}
    };
    
    class Article : PaperObject{
        protected:
            std::string jurnal;
            std::string number;
        public:
            Article(const std::string & _title, const std::string & _fio, size_t _yearMake,
                     const std::string & _jurnal, const std::string & _number) : PaperObject(_title, _fio, _yearMake),
                     jurnal(_jurnal), number(_number){}
            void setJurnal(const std::string & _jurnal){
                jurnal = _jurnal;
            }
            const std::string & getJurnal() const{
                return jurnal;
            }
            void setNumber(const std::string & _number){
                number = _number;
            }
            const std::string & getNumber() const{
                return number;
            }
            virtual void print() const{
                std::cout << "Article " << std::endl;
                std::cout << "Title : " << title << std::endl;
                std::cout << "FIO author : " << fio << std::endl;
                std::cout << "Year make : " << yearMake << std::endl;
                std::cout << "Jurnal : " << jurnal << std::endl;
                std::cout << "Number : " << number << std::endl;
                std::cout << std::endl;
            }
            virtual ~Article(){}
    };
    
    class Web : public Object{
        protected:
            std::string annotation;
            std::string link;
        public:
            Web(const std::string & _title, const std::string & _fio,
                     const std::string & _annotation, const std::string & _link) : Object(_title, _fio),
                     annotation(_annotation), link(_link){}
            void setAnnotation(const std::string & _annotation){
                annotation = _annotation;
            }
            const std::string & getAnnotation() const{
                return annotation;
            }
            void setLink(const std::string & _link){
                link = _link;
            }
            const std::string & getLink() const{
                return link;
            }
            virtual void print() const{
                std::cout << "Web " << std::endl;
                std::cout << "Title : " << title << std::endl;
                std::cout << "FIO author : " << fio << std::endl;
                std::cout << "Annotation : " << annotation << std::endl;
                std::cout << "Link : " << link << std::endl;
                std::cout << std::endl;
            }
            virtual ~Web(){}
    };
    
    template<class T>
    class Builder{
        private:
            Builder(){}
        public:
            static T * build(const std::string & _title, const std::string & _fio, size_t _yearMake,
                     const std::string & _publishingHouse){
                        return new T(_title, _fio, _yearMake, _publishingHouse);
            }
            static T * build(const std::string & _title, const std::string & _fio, size_t _yearMake,
                     const std::string & _jurnal, const std::string & _number){
                        return new T(_title, _fio, _yearMake, _jurnal, _number);            
            }
            static T * build(const std::string & _title, const std::string & _fio,
                     const std::string & _annotation, const std::string & _link){
                        return new T(_title, _fio, _annotation, _link);         
            }
    };
    
    class Catalog{
        private:
            std::vector<cf::Object *> catalog;
        public:
            void add(Object * obj){
                catalog.push_back(obj);
            }
            const Object * findByTitle(const std::string & _title) const{
                for(size_t i = 0; i < catalog.size(); ++i)
                    if(catalog[i]->getTitle() == _title)
                        return catalog[i];
            }
            const Object * findByAuthor(const std::string & _author) const{
                for(size_t i = 0; i < catalog.size(); ++i)
                    if(catalog[i]->getFIO() == _author)
                        return catalog[i];
            }
            void print() const{
                for(size_t i = 0; i < catalog.size(); ++i)
                    catalog[i]->print();
            }
    };
}
 
int main(){
    
    cf::Catalog catalog;
    
    catalog.add(reinterpret_cast<cf::Object *>(cf::Builder<cf::Book>::build(std::string("Book 1"), std::string("Author 1"), 2000, std::string("pub house 1"))));
    catalog.add(reinterpret_cast<cf::Object *>(cf::Builder<cf::Article>::build(std::string("Article 1"), std::string("Author 2"), 2000, std::string("IT"), std::string("#2"))));
    catalog.add(reinterpret_cast<cf::Object *>(cf::Builder<cf::Web>::build(std::string("Web 1"), std::string("Author 3"), std::string("Annotation 1"), std::string("www.jopa.com"))));
    
    catalog.print();
    
    return 0;
}
